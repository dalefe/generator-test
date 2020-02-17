package com.dalefe.generator.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dalefe
 * @date 2020/2/2
 */
@Data
public class Result {

	/**
	 * 返回状态码，200为正确，100为失败
	 */
	private int code;

	/**
	 * 返回处理信息，成功或者失败
	 */
	private String msg;

	/**
	 * 成功返回true，失败返回false
	 */
	private Boolean success;

	/**
	 * 返回给前端的数据
	 */
	private Map<String, Object> extend = new HashMap<String ,Object>();

	/**
	 * 成功返回的json封装体
	 * @param value 原始数据
	 * @return json格式
	 */
	public static Result successJson(Object value){
		Result results = new Result();
		results.setCode(ResultCode.SUCCESS.getIndex());
		results.setMsg(ResultCode.SUCCESS.getMsg());
		results.setSuccess(true);
		results.getExtend().put("data",value);

		return results;
	}

	/**
	 * 失败返回的json封装体
	 * @return json格式
	 */
	public static Result errorJson(String msg){
		Result results = new Result();
		results.setCode(ResultCode.FAIL.getIndex());
		results.setSuccess(false);
		results.setMsg(msg);
		return results;
	}

	/**
	 * 失败返回的json封装体
	 * @return json格式
	 */
	public static Result errorJson(String msg,Integer code){
		Result results = new Result();
		results.setCode(code);
		results.setSuccess(false);
		results.setMsg(msg);
		results.getExtend().put("data",null);
		return results;
	}



}


