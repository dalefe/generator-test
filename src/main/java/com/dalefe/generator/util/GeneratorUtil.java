package com.dalefe.generator.util;


import com.dalefe.generator.entity.Attribute;

import java.util.List;


/**
 * Author GreedyStar
 * Date   2018/4/19
 */
public class GeneratorUtil {

    /**
     * 生成Mapper 插入列名字段（所有关系皆用）
     *
     * @param infos
     * @return
     */
    public static String generateMapperInsertProperties(List<Attribute> infos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infos.size(); i++) {
            if (i != 0) {
                sb.append("            ");
            }
            sb.append(infos.get(i).getColumnName()+ ",\n");
        }
        return sb.toString().substring(0, sb.toString().length() - 2);
    }

    /**
     * 生成Mapper 插入属性字段（单表，多对多）
     */
    public static String generateMapperInsertValues(List<Attribute> infos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infos.size(); i++) {
            if (i != 0) {
                sb.append("            ");
            }
            sb.append("#{").append(infos.get(i).getName()).append("},\n");
        }
        return sb.toString().substring(0, sb.toString().length() - 2);
    }

    /**
     * 生成Mapper 更新属性字段
     */
    public static String generateMapperUpdateProperties(List<Attribute> infos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infos.size(); i++) {
	        //不允许更新id
	        if(infos.get(i).getColumnName().equals("id")){
		        continue;
	        }
            if (i != 0) {
                sb.append("        ");
            }
            sb.append(infos.get(i).getColumnName()).append(" = #{").append(infos.get(i).getName()).append("},\n");
        }
        return sb.toString().substring(0, sb.toString().length() - 2);
    }
}
