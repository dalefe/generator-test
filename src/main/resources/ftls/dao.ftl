package ${basePackageName}${packageName};

import ${basePackageName}${EntityPackageName}.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* @author ${author?if_exists}
* @date ${date}
*/
@Mapper
public interface ${ClassName}Dao {

public ${ClassName} get(String id);

public List<${ClassName}> findList(${ClassName} ${EntityName});

public List<${ClassName}> findAllList();

public int insert(${ClassName} ${EntityName});

public int insertBatch(List<${ClassName}> ${EntityName}s);

public int update(${ClassName} ${EntityName});

public int delete(${ClassName} ${EntityName});

}