package ${basePackage}.controller;

import com.mt.common.core.PageResult;
import com.mt.common.http.HttpResult;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @author ${author}
* @date ${date}
* @description //TODO ${modelNameUpperCamel}Controller
**/
@Api(tags = "${modelNameUpperCamel}Controller")
@RestController
@RequestMapping("${baseRequestMapping}")
@AllArgsConstructor
public class ${modelNameUpperCamel}Controller {

    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    public HttpResult<Void> add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return HttpResult.success();
    }

    @DeleteMapping
    public HttpResult<Void> delete(@RequestBody List<Long> ids) {
        ${modelNameLowerCamel}Service.batchDelete(ids);
        return HttpResult.success();
    }

    @PutMapping
    public HttpResult<Void> update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return HttpResult.success();
    }

    @GetMapping
    public HttpResult<PageResult<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return HttpResult.success(${modelNameLowerCamel}Service.listByPage(pageNum, pageSize, ${modelNameLowerCamel}));
    }
}
