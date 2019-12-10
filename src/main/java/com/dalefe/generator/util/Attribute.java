package com.dalefe.generator.util;

import lombok.Data;

/**
 * @author dalefe
 * @version  2019/11/07
 */
@Data
public class Attribute {
	private String columnName;
	private String type;
	private String name;
	private String remarks;
	private boolean isPrimaryKey; // 是否主键

	public Attribute(String attrType,String attrName,String remarks,String columnName,Boolean isPrimaryKey){
		this.type = attrType;
		this.name = attrName;
		this.remarks = remarks;
		this.columnName = columnName;
		this.isPrimaryKey = isPrimaryKey;
	}
}
