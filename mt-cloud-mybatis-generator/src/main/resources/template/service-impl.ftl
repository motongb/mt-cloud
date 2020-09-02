package ${serviceImplPackage};

import ${daoPackage}.${modelNameUpperCamel}Mapper;
import ${modelPackage}.${modelNameUpperCamel};
import ${servicePackage}.${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;
import com.mt.common.core.base.BaseServiceImpl;


/**
* @author ${author}
* @date ${date}
* @description //TODO ${modelNameUpperCamel}ServiceImpl
**/
@Service
public class ${modelNameUpperCamel}ServiceImpl extends BaseServiceImpl<${modelNameUpperCamel}, ${modelNameUpperCamel}Mapper> implements ${modelNameUpperCamel}Service {

}
