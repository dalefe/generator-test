package com.dalefe.generator.tasks;

import com.dalefe.generator.util.ConfigUtil;
import com.dalefe.generator.util.FileUtil;
import com.dalefe.generator.util.FreemarketConfigUtils;
import com.dalefe.generator.util.StringUtil;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author dalefe
 * @date 2020/2/3
 */
public class ControllerTask {
	public static Boolean markBeans(Map<String, Object> root, String str){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getController());
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = str + "Controller" + ".java";
		root.put("EntityName", StringUtil.firstToLowerCase(root.get("ClassName").toString()));
		root.put("PackageName",ConfigUtil.getConfiguration().getPath().getController());
		root.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
		root.put("ServicePackageName", ConfigUtil.getConfiguration().getPath().getService());
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_CONTROLLER, root, filePath + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return true;
	}
}
