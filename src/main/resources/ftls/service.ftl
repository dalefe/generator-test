package ${BasePackageName}${PackageName};

import ${BasePackageName}${EntityPackageName}.*;
import ${BasePackageName}${DaoPackageName}.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ${author?if_exists}
* @date ${date}
*/

@Service
public class ${ClassName}Service {

    @Autowired
    ${ClassName}Dao ${EntityName}dao;

    private ${ClassName} get(String id){
        return ${EntityName}dao.get(id);
    }

    private List<${ClassName}> findList(){
        return ${EntityName}dao.findList();
    }

    private int insert(${ClassName} ${EntityName}){
        return ${EntityName}dao.insert(${EntityName});
    }

    private int update(${ClassName} ${EntityName}){
        return ${EntityName}dao.update(${EntityName});
    }

    private int delete(${ClassName} ${EntityName}){
        return ${EntityName}dao.delete(${EntityName});
    }
}