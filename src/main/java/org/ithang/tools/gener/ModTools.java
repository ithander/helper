package org.ithang.tools.gener;

import java.util.HashMap;
import java.util.Map;

public class ModTools {

	
	private static Map<Class<?>,ModelSQL> mds=new HashMap<>();
	
	/**
	 * 获取ModelSQL实例
	 * @param cls
	 * @return
	 */
	public static ModelSQL getModelSQL(Class<?> cls){
		if(mds.containsKey(cls)){
			return mds.get(cls);
		}else{
			ModelSQL ms=new ModelSQL(cls);
			mds.put(cls, ms);
			return ms;
		}
	}
	
	
}
