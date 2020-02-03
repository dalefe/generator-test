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
public interface ${ClassName}Service {


public ${ClassName} get(String id);

public List<${ClassName}> findList();

public int insert(${ClassName} ${EntityName});

public int update(${ClassName} ${EntityName});

public int delete(${ClassName} ${EntityName});
}