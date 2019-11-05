package com.dalefe.generator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;


public class FreeMarkerInit {
	private static FreeMarkerInit single= new FreeMarkerInit();
	private FreeMarkerInit() {}
	//��̬��������
	public static FreeMarkerInit getInstance() {
		return single;
	}

	public Template getDefinedTemplate(String templateName) throws Exception{
		//������
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("D:/bishe/code/src/main/resources/template/"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		return cfg.getTemplate(templateName);
	}
}
