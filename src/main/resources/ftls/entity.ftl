package ${packageName};

import java.util.Date;
import lombok.Data;

/**
* @author ${author?if_exists}
* @date ${date?if_exists}
*/
@Data
public class ${className}{

<#-- 循环类型及属性 -->
<#list attrs as attr>
    private ${attr.type?if_exists} ${attr.name?if_exists};                                   //${attr.remarks?if_exists}
</#list>

}