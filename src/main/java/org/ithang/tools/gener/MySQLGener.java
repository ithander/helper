package org.ithang.tools.gener;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;
import org.ithang.tools.dao.Dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;


public class MySQLGener {
	
   private static SimpleTemplateEngine engine = null;
   private static Template beanTemplate=null;
   
   
   private final static Configuration configuration = new Configuration(Configuration.getVersion());
   private final static StringTemplateLoader loader=new StringTemplateLoader();
   static{
	   try {
		    engine = new groovy.text.SimpleTemplateEngine();
		    beanTemplate=engine.createTemplate(FTL.getBeanFTL());
		    
		    
		    configuration.setDefaultEncoding("utf-8");
		    configuration.setTemplateLoader(loader);
		    loader.putTemplate("personQuery", null);
		} catch (CompilationFailedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
   
	/**
	 * 生成Bean
	 * @param tableName
	 */
	public static String printBean(String tableName){
		try{
			Map<String,Object> bind=new HashMap<>();
			bind.put("clsName", tableName);
			bind.put("fields", null);
			
			JdbcTemplate jdbcTemplate=Dao.getJdbcTemplate();
			jdbcTemplate.query("SHOW FULL COLUMNS FROM "+tableName, new RowMapper<ModelBean>(){

				@Override
				public ModelBean mapRow(ResultSet rs, int index) throws SQLException {
					ModelBean mb=new ModelBean();
					return mb;
				}
				
			});
			
			Writable result= beanTemplate.make(bind);
			StringWriter sw = new StringWriter();
			result.writeTo(sw);
			String rs=sw.toString();
			sw.close();
			return rs;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 生成service
	 * @param tableName
	 */
	public static void processServices(String ... tableName){
		
		
	}
	
	/**
	 * 处理模板和数据 产生结果
	 * @param template
	 * @param bind
	 * @return
	 */
	public static String process(String template,Map<String,Object> bind) {
		try{
			Template tempTemplate=engine.createTemplate(template);
			Writable result= tempTemplate.make(bind);
			StringWriter sw = new StringWriter();
			result.writeTo(sw);
			String rs=sw.toString();
			sw.close();
			return rs;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}


class ModelBean{
	private String Type;//字段类型
	private String Field;//字段名称
	private boolean Key;//是否是主键
	private String Comment;
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
	}
	public boolean isKey() {
		return Key;
	}
	public void setKey(boolean key) {
		Key = key;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
}
