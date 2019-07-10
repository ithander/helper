package org.ithang.tools.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> extends Dao {

	/**
	 * 查询所有数据
	 * @return
	 */
	public List<T> list(){
		Class<T> type=(Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("eee="+type.getName());
		return null;
	}
	
	/**
	 * 保存数据
	 * @param bean
	 * @return
	 */
	public String insert(T bean){
		return null;
	}
	
	/**
	 * 修改数据
	 * @param bean
	 * @return
	 */
	public int update(T bean){
		return 0;
	}
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
    public int delete(Integer... id){
    	return 0;
	}
	
    /**
     * 删除数据
     * @param id
     * @return
     */
	public int delete(String... id){
		return 0;
	}
	
}
