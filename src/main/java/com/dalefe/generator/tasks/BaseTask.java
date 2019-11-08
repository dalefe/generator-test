package com.dalefe.generator.tasks;

import com.dalefe.generator.util.*;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dalefe
 * @date 2019/11/8
 */
@Data
@Component
public class BaseTask {

//	@Autowired
//	EntityTask entityTask;
//
//	@Autowired
//	DaoTask daoTask;



	//生成bean
	@Test
	public void getBean() throws Exception {
		//获取表名集合
		List<String> strs = MetadataUtil.getTableNames();
		for (String str1 : strs
		) {
			if (str1.equals("sys_config")) {
				continue;
			}
			List<String[]> strList = MetadataUtil.getTableColumnsInfo(str1);
			List<Attribute> attr_list = new ArrayList<>();
			for (String[] c : strList
			) {
				if (JavaNameUtil.dbTypeChangeJavaType(c[2]).equals("") ||
						JavaNameUtil.toCamel(c[0]).equals("")) {
					continue;
				}
				attr_list.add(new Attribute(JavaNameUtil.dbTypeChangeJavaType(c[2]), JavaNameUtil.toCamel(c[0]), c[1]));
			}
			//装换为帕斯卡命名
			String str = JavaNameUtil.toPascal(str1);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
			Map<String, Object> root = new HashMap<>();
			root.put("basePackageName", ConfigUtil.getConfiguration().getPackageName() + ".");
//			root.put("packageName",ConfigUtil.getConfiguration().getPath().getEntity());
			root.put("ClassName", str);
			root.put("attrs", attr_list);
			root.put("author", ConfigUtil.getConfiguration().getAuthor());
			root.put("date", sd.format(new Date()));
//			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, root, filePath + fileName);
			EntityTask.markBean(root,str);
			DaoTask.markBeans(root,str);
		}

	}
}
