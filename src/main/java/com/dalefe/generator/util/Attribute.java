package com.dalefe.generator.util;

import lombok.Data;

/**
 * @author dalefe
 * @version  2019/11/07
 */
@Data
public class Attribute {
	public String type;
	public String name;
	public String remarks;
public Attribute(String attrType,String attrName,String remarks){
	this.type = attrType;
	this.name = attrName;
	this.remarks = remarks;
}
}
