package com.dalefe.generator.tasks;

import com.dalefe.generator.util.*;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author dalefe
 * @date 2019/11/8
 */
public class MapperTask {
	public static Boolean markBeans(Map<String, Object> root, String str){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getMapper());
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = str + "Mapper.xml";
		root.put("DaoPackageName", ConfigUtil.getConfiguration().getPath().getDao()+".");
		root.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
		root.put("PrimaryKey","id");
		root.put("id","id");
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_MAPPER, root, filePath + fileName);
		} catch (IOException e) {
			System.out.println("Mapper"+e);
		} catch (TemplateException e) {
			System.out.println("Mapper"+e);
		}
		return true;
	}
}
