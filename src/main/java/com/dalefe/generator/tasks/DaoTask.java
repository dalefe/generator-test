package com.dalefe.generator.tasks;


import com.dalefe.generator.util.ConfigUtil;
import com.dalefe.generator.util.FileUtil;
import com.dalefe.generator.util.FreemarketConfigUtils;
import com.dalefe.generator.util.StringUtil;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author dalefe
 * @date 2019/11/8
 */
@Component
public class DaoTask{

	public static Boolean markBeans(Map<String, Object> root, String str){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getDao());
		String fileName = str + "Dao" + ".java";
		root.put("EntityName", StringUtil.firstToLowerCase(root.get("ClassName").toString()));
		root.put("packageName",ConfigUtil.getConfiguration().getPath().getDao());
		root.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_DAO, root, filePath + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return true;
	}

}
