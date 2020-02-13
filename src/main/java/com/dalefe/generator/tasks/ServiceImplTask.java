package com.dalefe.generator.tasks;

import com.dalefe.generator.util.ConfigUtil;
import com.dalefe.generator.util.FileUtil;
import com.dalefe.generator.util.FreemarketConfigUtils;
import com.dalefe.generator.util.StringUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * @author dalefe
 * @date 2020/2/2
 */
public class ServiceImplTask {
	public static Boolean markBeans(Map<String, Object> root, String str){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getInterf());
		String fileName = str + "ServiceImpl" + ".java";
		root.put("EntityName", StringUtil.firstToLowerCase(root.get("ClassName").toString()));
		root.put("PackageName",ConfigUtil.getConfiguration().getPath().getInterf());
		root.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
		root.put("DaoPackageName", ConfigUtil.getConfiguration().getPath().getDao());
		root.put("ServicePackage",ConfigUtil.getConfiguration().getPath().getService());
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_INTERFACE, root, filePath + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return true;
	}
}
