package com.dalefe.generator.entity;

import lombok.Data;

/**
 * @author dalefe
 * @date 2020/2/13
 */
@Data
public class TableInfo {
	private int key;
	private String label;
	public TableInfo(int key,String lable){
		this.key = key;
		this.label = lable;
	}
}
