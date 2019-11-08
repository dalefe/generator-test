package com.dalefe.generator.tasks;

import com.dalefe.generator.util.*;
import freemarker.template.TemplateException;
import lombok.Data;

import java.io.IOException;
import java.util.Map;


/**
 * @author dalefe
 * @version  2019/11/07
 */
@Data
public class EntityTask{

	/**
	 * 生成实际Entity
	 * @author dalefe
	 * @version  2019/11/8
	 * @param
	 * @return
	 */
	public static Boolean markBean(Map<String, Object> root,String str){
		String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getEntity());
		String fileName = str + ".java";
		root.put("packageName",ConfigUtil.getConfiguration().getPath().getEntity());
		try {
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, root, filePath + fileName);
		} catch (IOException e) {
			System.out.println("Entity"+e);
		} catch (TemplateException e) {
			System.out.println("Entity"+e);
		}
		return true;
	}

}
