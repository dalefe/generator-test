package com.dalefe.generator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;


public class FreeMarkerInit {
	private static FreeMarkerInit single= new FreeMarkerInit();
	private FreeMarkerInit() {}
	//静态工厂方法
	public static FreeMarkerInit getInstance() {
		return single;
	}

	public Template getDefinedTemplate(String templateName) throws Exception{
		//配置类
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("D:/bishe/code/src/main/resources/template/"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		return cfg.getTemplate(templateName);
	}
}
