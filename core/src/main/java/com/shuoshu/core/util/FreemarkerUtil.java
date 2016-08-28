package com.shuoshu.core.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 工具类-freemarker的模板处理
 * @author lh
 * @version 3.0
 * @date 2016年4月28日
 */
public class FreemarkerUtil {

	private static Logger logger = LoggerFactory.getLogger(FreemarkerUtil.class);

	private static final String FILE_SEPARATOR = "/";
	public static Configuration CONFIG;
	
	public static String renderTemplate(String s, Map<String, Object> data) throws IOException, TemplateException {
		if(CONFIG==null){
			CONFIG =  new Configuration();
		}
		CONFIG.setDefaultEncoding("UTF-8");
		Template t = new Template(null, new StringReader(s), CONFIG);
		// 执行插值，并输出到指定的输出流中
		StringWriter w = new StringWriter();
		try {
			t.process(data, w);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn(data.get("noticeTime").toString(),e);
		}
		return w.getBuffer().toString();
	}
	
	
	public static String renderFileTemplate(String templatePath, Map<String, Object> data) throws IOException, TemplateException {
		// 执行插值，并输出到指定的输出流中
		StringWriter w = new StringWriter();
		getTemplate(templatePath).process(data, w);
		return w.getBuffer().toString();
	}
	
	public static void renderFileTemplate(String templatePath, Map<String, Object> data, String savePath)throws IOException, TemplateException {
		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(new File(savePath));
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			out = new BufferedWriter(osw);
			getTemplate(templatePath).process(data,out);
			
		} finally{
			if(out!=null){
				out.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}
	
	private static Template getTemplate(String templatePath) throws IOException{
		Configuration cfg = CONFIG;
		if(cfg==null){	cfg =  new Configuration(); }
		cfg.setDefaultEncoding("UTF-8");
		String path = templatePath.substring(0, templatePath.lastIndexOf(FILE_SEPARATOR));
		String name = templatePath.substring(templatePath.lastIndexOf(FILE_SEPARATOR) + 1 );
		// 加载模板文件
		cfg.setClassForTemplateLoading(FreemarkerUtil.class, path);
		// 设置对象包装器
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		// 设置异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		return cfg.getTemplate(name);
	}

}
