package com.dalefe.generator.util;

import lombok.Data;

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
