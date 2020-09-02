package com.mt.mybatis.generator;

import java.time.LocalDateTime;

/**
 * @author motb
 * @date 2020/8/26 16:07
 * @description //TODO GeneratorConst
 **/
public interface GeneratorConst {
    /**
     * 包路径配置
     * <p>
     * 生成代码所在的基础包名称，可根据项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
     */
    String BASE_PACKAGE = "com.mt.mybatis";
    /**
     * 生成的Model所在包
     */
    String MODEL_PACKAGE = BASE_PACKAGE + ".model";
    /**
     * 生成的Mapper所在包
     */
    String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";
    /**
     * 生成的Service所在包
     */
    String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
    /**
     * 生成的ServiceImpl所在包
     */
    String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
    /**
     * 生成的Controller所在包
     */
    String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";
    /**
     * Mapper插件基础接口的完全限定名
     */
    String MAPPER_INTERFACE_REFERENCE = "com.mt.common.core.SysBaseMapper";
    /**
     * entity父类
     */
    String ENTITY_SUPER_REFERENCE = "com.mt.common.core.base.BaseEntity";

    /**
     * JDBC配置，请修改为你项目的实际配置
     */
    String JDBC_URL = "jdbc:mysql://localhost:3306/mt_cloud_base?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
    String JDBC_USERNAME = "root";
    String JDBC_PASSWORD = "123456";
    String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    /**
     * 项目在硬盘上的基础路径
     */
    String PROJECT_PATH = System.getProperty("user.dir");
    /**
     * 生成文件模块路径
     */
    String MODULE_PATH = "/mt-cloud-center/mt-cloud-mybatis";
    /**
     * 模板位置
     */
    String TEMPLATE_FILE_PATH = PROJECT_PATH + "/mt-cloud-mybatis-generator/src/main/resources/template";
    /**
     * java文件路径
     */
    String JAVA_PATH = MODULE_PATH + "/src/main/java";
    /**
     * 资源文件路径
     */
    String RESOURCES_PATH = MODULE_PATH + "/src/main/resources";
    /**
     * 生成的Service存放路径
     */
    String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);
    /**
     * 生成的Service实现存放路径
     */
    String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);
    /**
     * 生成的Controller存放路径
     */
    String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);

    /**
     * 创建人
     */
    String AUTHOR = "motb";
    /**
     * 日期
     */
    String DATE = LocalDateTime.now().toString();

    static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
}
