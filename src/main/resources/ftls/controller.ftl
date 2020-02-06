package ${BasePackageName}${PackageName};

import ${BasePackageName}${EntityPackageName}.*;
import ${BasePackageName}${ServicePackageName}.*;
import com.dalefe.generator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @author ${author?if_exists}
* @date ${date}
*/

@RestController
public class ${ClassName}Controller {

    @Autowired
    ${ClassName}Service ${EntityName}Service;

    @RequestMapping("get${ClassName}")
    private Result get(String id){
        return Result.successJson(${EntityName}Service.get(id));
    }

    @RequestMapping("findList${ClassName}")
    private Result findList(){
        return Result.successJson(${EntityName}Service.findList());
    }

    @RequestMapping("insert${ClassName}")
    private Result insert(${ClassName} ${EntityName}){
        return Result.successJson(${EntityName}Service.insert(${EntityName}));
    }

    @RequestMapping("update${ClassName}")
    private Result update(${ClassName} ${EntityName}){
        return Result.successJson(${EntityName}Service.update(${EntityName}));
    }

    @RequestMapping("delete${ClassName}")
    private Result delete(${ClassName} ${EntityName}){
        return Result.successJson(${EntityName}Service.delete(${EntityName}));
    }
}