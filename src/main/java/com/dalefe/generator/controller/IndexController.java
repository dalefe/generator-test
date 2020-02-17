package com.dalefe.generator.controller;

import com.dalefe.generator.entity.TableName;
import com.dalefe.generator.tasks.BaseTask;
import com.dalefe.generator.util.MetadataUtil;
import com.dalefe.generator.util.Result;
import com.dalefe.generator.entity.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dalefe
 * @date 2020/2/6
 */
@CrossOrigin
@RestController
public class IndexController {

	@Autowired
	private BaseTask baseTask;

	@RequestMapping("index")
	public Result index(){
		List<Object> tableObject = new ArrayList<>();
		List<String> tableNames = MetadataUtil.getTableNames();
		for(int i=0;i<tableNames.size();i++){
			tableObject.add(new TableInfo(i,tableNames.get(i)));
		}
		return Result.successJson(tableObject);
	}

	@RequestMapping("getBean")
	public Result getBean(@RequestBody TableName tableName){
		if(tableName==null||tableName.getTableList()==null){
			return Result.errorJson("表名集合错误，请重试");
		}else if(tableName.getTableList().size()==0){
			return Result.errorJson("请选择需要生成的表");
		}
		try {
			baseTask.getBean(tableName.getTableList());
			return Result.successJson("成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.successJson("失败");
	}
}
