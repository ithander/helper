package org.ithang.tools.gener;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Entity {

	
	/**
	 * 模板数据
	 * @return
	 */
	public Map<String,Object> bindata(){
		Field[] fields=this.getClass().getDeclaredFields();
		Map<String,Object> result=new HashMap<>(fields.length+5);
		if(null!=fields&&fields.length>0){
			try{
				for(Field field:fields){
					field.setAccessible(true);
					result.put(field.getName(), field.get(this));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
