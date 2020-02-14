package ${BasePackageName}${PackageName};

import ${BasePackageName}${EntityPackageName}.*;
import ${BasePackageName}${ServicePackageName}.*;
import com.dalefe.generator.util.MetadataUtil;
import com.dalefe.generator.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;

/**
* @author ${author?if_exists}
* @date ${date}
*/
@CrossOrigin
@RestController
public class ${ClassName}Controller {

    @Autowired
    ${ClassName}Service ${EntityName}Service;

    @RequestMapping("get${ClassName}")
    private Result get(String id){
        ${ClassName} ${EntityName} = ${EntityName}Service.get(id);
        if(${EntityName}!=null){
            return Result.successJson(${EntityName});
        }else {
        return Result.errorJson("查询结果不存在或未使用Id查询",400);
        }
    }

    @RequestMapping("findList${ClassName}")
    private Result findList(){
        HashMap<String,Object> listInfo = new HashMap<>();
        listInfo.put("tableInnerInfo",${EntityName}Service.findList());
        try {
        listInfo.put("tableHeadInfo",MetadataUtil.gettableInfoByTableName("${TableName}"));
        return Result.successJson(listInfo);
        } catch (Exception e) {
        e.printStackTrace();
        }
        return Result.errorJson("查询列表信息失败",405);
    }

    @RequestMapping("insert${ClassName}")
    private Result insert(@RequestBody ${ClassName} ${EntityName}){
        return Result.successJson(${EntityName}Service.insert(${EntityName}));
    }

    @RequestMapping("update${ClassName}")
    private Result update(@RequestBody ${ClassName} ${EntityName}){
        return Result.successJson(${EntityName}Service.update(${EntityName}));
    }

    @RequestMapping("delete${ClassName}")
    private Result delete(@RequestBody ${ClassName} ${EntityName}){
        return Result.successJson(${EntityName}Service.delete(${EntityName}));
    }
}