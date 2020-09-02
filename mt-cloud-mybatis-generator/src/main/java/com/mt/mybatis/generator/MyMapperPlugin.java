package com.mt.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;
import tk.mybatis.mapper.generator.FalseMethodPlugin;

import java.util.*;

/**
 * @author motb
 * @date 2020/8/28 10:00
 * @description //TODO MyMapperPlugin自定义模板
 **/
public class MyMapperPlugin extends FalseMethodPlugin {

    private Set<String> mappers = new HashSet<>();
    private String supClass = "";
    private boolean caseSensitive = false;
    private boolean useMapperCommentGenerator = true;
    private String beginningDelimiter = "";
    private String endingDelimiter = "";
    private String schema;
    private CommentGeneratorConfiguration commentCfg;
    private boolean forceAnnotation;
    private boolean needsData = false;
    private boolean needsAccessors = false;
    private boolean generateColumnConsts = false;
    private Set<String> filterField = new HashSet<>();

    public MyMapperPlugin() {
    }

    public String getDelimiterName(String name) {
        StringBuilder nameBuilder = new StringBuilder();
        if (StringUtility.stringHasValue(this.schema)) {
            nameBuilder.append(this.schema);
            nameBuilder.append(".");
        }

        nameBuilder.append(this.beginningDelimiter);
        nameBuilder.append(name);
        nameBuilder.append(this.endingDelimiter);
        return nameBuilder.toString();
    }

    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        Iterator<String> var5 = this.mappers.iterator();

        while (var5.hasNext()) {
            String mapper = var5.next();
            interfaze.addImportedType(new FullyQualifiedJavaType(mapper));
            interfaze.addSuperInterface(new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
        }

        interfaze.addImportedType(entityType);
        return true;
    }

    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("javax.persistence.*");
        if (this.needsData) {
            topLevelClass.addImportedType("lombok.Data");
            topLevelClass.addAnnotation("@Data");
        }

        if (this.needsAccessors) {
            topLevelClass.addImportedType("lombok.experimental.Accessors");
            topLevelClass.addAnnotation("@Accessors(chain = true)");
        }

        if (StringUtility.stringHasValue(this.supClass)) {
            topLevelClass.addImportedType(this.supClass);
            topLevelClass.setSuperClass(new FullyQualifiedJavaType(this.supClass));
            topLevelClass.addImportedType("lombok.EqualsAndHashCode");
            topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");
        }

        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        if (StringUtility.stringContainsSpace(tableName)) {
            tableName = this.context.getBeginningDelimiter() + tableName + this.context.getEndingDelimiter();
        }

        if (this.caseSensitive && !topLevelClass.getType().getShortName().equals(tableName)) {
            topLevelClass.addAnnotation("@Table(name = \"" + this.getDelimiterName(tableName) + "\")");
        } else if (!topLevelClass.getType().getShortName().equalsIgnoreCase(tableName)) {
            topLevelClass.addAnnotation("@Table(name = \"" + this.getDelimiterName(tableName) + "\")");
        } else if (!StringUtility.stringHasValue(this.schema) && !StringUtility.stringHasValue(this.beginningDelimiter) && !StringUtility.stringHasValue(this.endingDelimiter)) {
            if (this.forceAnnotation) {
                topLevelClass.addAnnotation("@Table(name = \"" + this.getDelimiterName(tableName) + "\")");
            }
        } else {
            topLevelClass.addAnnotation("@Table(name = \"" + this.getDelimiterName(tableName) + "\")");
        }

        if (this.generateColumnConsts) {
            Iterator<IntrospectedColumn> var4 = introspectedTable.getAllColumns().iterator();
            while (var4.hasNext()) {
                IntrospectedColumn introspectedColumn = var4.next();
                String upperCase = introspectedColumn.getActualColumnName().toUpperCase();
                Field field = new Field(upperCase, new FullyQualifiedJavaType(String.class.getName()));
                field.setVisibility(JavaVisibility.PUBLIC);
                field.setStatic(true);
                field.setFinal(true);
                field.setInitializationString("\"" + introspectedColumn.getJavaProperty() + "\"");
                topLevelClass.addField(field);
            }
        }

    }

    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return !this.needsData;
    }

    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return !this.needsData;
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.processEntityClass(topLevelClass, introspectedTable);
        return false;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return !filterField.contains(field.getName());
    }

    public void setContext(Context context) {
        super.setContext(context);
        this.useMapperCommentGenerator = !"FALSE".equalsIgnoreCase(context.getProperty("useMapperCommentGenerator"));
        if (this.useMapperCommentGenerator) {
            this.commentCfg = new CommentGeneratorConfiguration();
            this.commentCfg.setConfigurationType(MyMapperCommentGenerator.class.getCanonicalName());
            context.setCommentGeneratorConfiguration(this.commentCfg);
        }

        context.getJdbcConnectionConfiguration().addProperty("remarksReporting", "true");
    }

    private void setFilterField(Properties properties) {
        String filterFields = this.getProperty("filterFields");
        if (StringUtility.stringHasValue(filterFields)) {
            String[] val0 = filterFields.split(",");
            Collections.addAll(this.filterField, val0);
        }
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.setFilterField(properties);
        String mappers = this.getProperty("mappers");
        if (!StringUtility.stringHasValue(mappers)) {
            throw new RuntimeException("Mapper插件缺少必要的mappers属性!");
        } else {
            String[] var3 = mappers.split(",");
            Collections.addAll(this.mappers, var3);

            this.supClass = this.getProperty("supClass");
            this.caseSensitive = Boolean.parseBoolean(this.properties.getProperty("caseSensitive"));
            this.forceAnnotation = this.getPropertyAsBoolean("forceAnnotation");
            this.beginningDelimiter = this.getProperty("beginningDelimiter", "");
            this.endingDelimiter = this.getProperty("endingDelimiter", "");
            this.schema = this.getProperty("schema");
            String lombok = this.getProperty("lombok");
            if (lombok != null && !"".equals(lombok)) {
                this.needsData = lombok.contains("Data");
                this.needsAccessors = lombok.contains("Accessors");
            }

            if (this.useMapperCommentGenerator) {
                this.commentCfg.addProperty("beginningDelimiter", this.beginningDelimiter);
                this.commentCfg.addProperty("endingDelimiter", this.endingDelimiter);
                String forceAnnotation = this.getProperty("forceAnnotation");
                if (StringUtility.stringHasValue(forceAnnotation)) {
                    this.commentCfg.addProperty("forceAnnotation", forceAnnotation);
                }
                this.commentCfg.addProperty("swagger", this.getProperty("swagger"));
            }

            this.generateColumnConsts = this.getPropertyAsBoolean("generateColumnConsts");
        }
    }

    protected String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    protected String getProperty(String key, String defaultValue) {
        return this.properties.getProperty(key, defaultValue);
    }

    protected Boolean getPropertyAsBoolean(String key) {
        return Boolean.parseBoolean(this.getProperty(key));
    }
}
