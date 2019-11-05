package com.dalefe.generator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.dalefe.generator.util.*;
import freemarker.template.Template;
import org.junit.Test;

public class entityTest {



	//生成bean
	@Test
	public void gen1() throws Exception{
		//生成路径
//		String savePath="D:\\bishe\\code\\src\\main\\java\\com\\dalefe\\generator\\pojo";
		//获取模板
		Template temp = FreeMarkerInit.getInstance().getDefinedTemplate("javabean.ftl");
		//获取表名集合
		List<String> strs=MetadataUtil.getTableNames();
		for (String str1: strs
		) {
			if(str1.equals("sys_config")){
				continue;
			}
			//Attribute里面封装模板使用属性
			List<String[]> strList=MetadataUtil.getTableColumnsInfo(str1);
			List<Attribute> attr_list = new ArrayList<Attribute>();
			for (String[] c:strList
			) {
				if(JavaNameUtil.dbTypeChangeJavaType(c[2]).equals("") ||
						JavaNameUtil.toCamel(c[0]).equals("")){
					continue;
				}
				attr_list.add(new Attribute(JavaNameUtil.dbTypeChangeJavaType(c[2]), JavaNameUtil.toCamel(c[0]),c[1]));
			}

			//装换为帕斯卡命名
			String str=JavaNameUtil.toPascal(str1);

			Map<String, Object> root = new HashMap<String, Object>();
			String filePath = ConfigUtil.getConfiguration().getPackageName()+ConfigUtil.getConfiguration().getPath().getEntity();
			root.put("packageName", "filePath");
			root.put("className", str);
			root.put("attrs", attr_list);
			System.out.println(ConfigUtil.getConfiguration().getPackageName()+ConfigUtil.getConfiguration().getPath().getEntity());
			OutputStream fos = new  FileOutputStream( new File(filePath, str+".java"));
			Writer out = new OutputStreamWriter(fos);
			temp.process(root, out);
			fos.flush();
			fos.close();
		}

	}




}
