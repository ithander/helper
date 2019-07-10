package org.ithang.tools.dao;

import java.util.List;

public class MService<T> extends BaseDao<T> {

	
	public List<T> query(String SQLKey){
		System.out.println("service="+this.getClass().getGenericSuperclass());
		System.out.println("service="+this.getClass().getGenericInterfaces());
		return null;
	}
	
	
	public List<T> query(String SQLKey,int pageIndex,int pageSize){
		return null;
	}
	
	
}
