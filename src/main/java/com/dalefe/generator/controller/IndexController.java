package com.dalefe.generator.controller;

import com.dalefe.generator.tasks.BaseTask;
import com.dalefe.generator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalefe
 * @date 2020/2/6
 */
@RestController
public class IndexController {

	@Autowired
	private BaseTask baseTask;

	@RequestMapping("index")
	public Result index(){
		try {
			baseTask.getBean();
			return Result.successJson("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.errorJson("生成代码失败了");
	}
}
