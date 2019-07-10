package org.ithang.tools.dao

class MySQL {

	
	static def beansSQL=[test:"select 1"]
	
	
	static void addSQL(String key,String SQL){
		beansSQL.put(key, SQL);
	}
	
	static void delSQL(String key){
		beansSQL.remove(key);
	}
	
	static void updateSQL(String key,String SQL){
		beansSQL.put(key, SQL);
	}
	
	static String getBeansSQL(String key){
		beansSQL.get(key);
	}
	
}
