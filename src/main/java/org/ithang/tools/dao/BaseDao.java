package org.ithang.tools.dao;

public class BaseDao<T> extends Dao {

	
	public String insert(T... bean){
		return null;
	}
	
	public int update(T... bean){
		return 0;
	}
	
    public int delete(Integer... id){
    	return 0;
	}
	
	public int delete(String... id){
		return 0;
	}
	
}
