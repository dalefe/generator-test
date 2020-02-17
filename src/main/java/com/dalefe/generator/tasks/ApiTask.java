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
 * @date 2020/2/17
 */
public class ApiTask {
	public static Boolean markBeans(Map<String, Object> root, String str){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName())
				+ StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getApi());
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = root.get("ClassName") + ".js";
		root.put("EntityName", StringUtil.firstToLowerCase(str));
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_API, root, filePath + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return true;
	}
}
