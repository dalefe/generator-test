package ${BasePackageName}${PackageName};

import ${BasePackageName}${EntityPackageName}.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
* @author ${author?if_exists}
* @date ${date}
*/
@Mapper
public interface ${ClassName}Dao {

public ${ClassName} get(${ClassName} ${EntityName});

public List<${ClassName}> findList();

public int insert(${ClassName} ${EntityName});

public int update(${ClassName} ${EntityName});

public int delete(${ClassName} ${EntityName});

}