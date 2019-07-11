package org.ithang.service.engine;

import java.util.List;
import java.util.Map;

import org.ithang.tools.dao.MService;

import groovy.lang.GroovyClassLoader;

public class GroovyService extends MService<Map<String,Object>>{

	private static GroovyClassLoader loader=new GroovyClassLoader();
	
	
	
	public List<Map<String,Object>> execute(String scriptTxt){
		loader.parseClass(scriptTxt);
		return null;
	}
	
}
