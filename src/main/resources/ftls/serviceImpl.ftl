package ${BasePackageName}${PackageName};

import ${BasePackageName}${EntityPackageName}.*;
import ${BasePackageName}${DaoPackageName}.*;
import ${BasePackageName}${ServicePackage}.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
* @author ${author?if_exists}
* @date ${date}
*/

@Service
public class ${ClassName}ServiceImpl implements ${ClassName}Service {

    @Autowired
    ${ClassName}Dao ${EntityName}Dao;

    public ${ClassName} get(String id){
        return ${EntityName}Dao.get(id);
    }

    public List<${ClassName}> findList(){
        return ${EntityName}Dao.findList();
    }

    public int insert(${ClassName} ${EntityName}){
        ${EntityName}.setId(UUID.randomUUID().toString());
        return ${EntityName}Dao.insert(${EntityName});
    }

    public int update(${ClassName} ${EntityName}){
        return ${EntityName}Dao.update(${EntityName});
    }

    public int delete(${ClassName} ${EntityName}){
        return ${EntityName}Dao.delete(${EntityName});
    }
}