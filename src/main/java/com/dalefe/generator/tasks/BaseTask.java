package com.dalefe.generator.tasks;

import com.dalefe.generator.entity.Attribute;
import com.dalefe.generator.util.*;
import lombok.Data;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import static com.dalefe.generator.util.GeneratorUtil.*;

/**
 * @author dalefe
 * @date 2019/11/8
 */
@Data
@Service
public class BaseTask {


	private EntityTask entityTask;

	private DaoTask daoTask;

	private MapperTask mapperTask;

	private ServiceImplTask serviceImplTask;

	private ControllerTask controllerTask;

	private ServiceTask serviceTask;

	private VueTask vueTask;

	private ApiTask apiTask;

	private RouteTask routeTask;




	public void getBean(List<String> tableName) throws Exception {
		setDaoTask(daoTask);
		setEntityTask(entityTask);
		setMapperTask(mapperTask);
	    setServiceImplTask(serviceImplTask);
		setControllerTask(controllerTask);
		setServiceTask(serviceTask);
		setVueTask(vueTask);
		setApiTask(apiTask);
		setRouteTask(routeTask);
		Map<String, Object> routeData = new HashMap<>();
		List<String> routeList = new ArrayList<>();
		for (String str1 : tableName
		) {
			List<String[]> strList = MetadataUtil.getTableColumnsInfo(str1);
			List<Attribute> attr_list = new ArrayList<>();
			for (String[] c : strList
			) {
				if (JavaNameUtil.dbTypeChangeJavaType(c[2]).equals("") ||
						JavaNameUtil.toCamel(c[0]).equals("")) {
					continue;
				}
				attr_list.add(new Attribute(JavaNameUtil.dbTypeChangeJavaType(c[2]), JavaNameUtil.toCamel(c[0]), c[1],c[0],false));
			}
			//装换为帕斯卡命名
			String str = JavaNameUtil.toPascal(str1);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
			Map<String, Object> root = new HashMap<>();
			root.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName() + ".");
			root.put("ClassName", str);
			root.put("attrs", attr_list);
			root.put("author", ConfigUtil.getConfiguration().getAuthor());
			root.put("date", sd.format(new Date()));
			root.put("TableName",str1);
			root.put("InsertProperties",generateMapperInsertProperties(attr_list));              //插入字段名
			root.put("InsertValues",generateMapperInsertValues(attr_list));                     //插入字段属性
			root.put("UpdateProperties",generateMapperUpdateProperties(attr_list));             //更新字段
			entityTask.markBean(root,str);
			daoTask.markBeans(root,str);
			mapperTask.markBeans(root,str);
			serviceTask.markBeans(root,str);
			serviceImplTask.markBeans(root,str);
			controllerTask.markBeans(root,str);
			vueTask.markBeans(root,str);
			apiTask.markBeans(root,str);
			routeList.add(StringUtil.firstToLowerCase(str));
		}
		routeData.put("RouteDatas",routeList);
		routeTask.markBeans(routeData);
	}
}
