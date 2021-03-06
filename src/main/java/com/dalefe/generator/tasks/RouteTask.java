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
public class RouteTask {
	public static Boolean markBeans(Map<String, Object> root){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName())
				+ StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getRoute());
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = "index.js";
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ROUTE, root, filePath + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return true;
	}
}
