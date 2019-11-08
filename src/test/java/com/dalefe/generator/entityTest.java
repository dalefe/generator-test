package com.dalefe.generator;
import java.text.SimpleDateFormat;
import java.util.*;

import com.dalefe.generator.tasks.BaseTask;
import com.dalefe.generator.util.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dalefe
 * @version  2019/11/07
 */
public class entityTest {

	@Autowired
	BaseTask baseTask;



	//生成bean
	@Test
	public void gen1() throws Exception{
		baseTask.getBean();
	}




}
