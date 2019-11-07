package com.dalefe.generator;
import java.text.SimpleDateFormat;
import java.util.*;
import com.dalefe.generator.util.*;
import org.junit.Test;
/**
 * @author dalefe
 * @version  2019/11/07
 */
public class entityTest {




	//生成bean
	@Test
	public void gen1() throws Exception{
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
			SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
			Map<String, Object> root = new HashMap<String, Object>();
			String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getEntity());
			String fileName = str + ".java";
			root.put("packageName",ConfigUtil.getConfiguration().getPackageName() + "." + ConfigUtil.getConfiguration().getPath().getEntity());
			root.put("className", str);
			root.put("attrs", attr_list);
			root.put("author",ConfigUtil.getConfiguration().getAuthor());
			root.put("date",sd.format(new Date()));
			FileUtil.generateToJava(FreemarketConfigUtils.TYPE_ENTITY, root, filePath + fileName);
		}

	}




}
