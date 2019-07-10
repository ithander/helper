package org.ithang.tools.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.ithang.tools.gener.ModTools;
import org.ithang.tools.gener.ModelSQL;
import org.springframework.jdbc.core.RowMapper;

public class BaseDao<T> extends Dao {

	/**
	 * 查询所有数据
	 * @return
	 */
	public List<T> list(){
		final Class<T> type=(Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		ModelSQL ms=ModTools.getModelSQL(type);
		return getJdbcTemplate().query("select * from "+ms.getTableName(),new RowMapper<T>(){

			@Override
			public T mapRow(ResultSet rs, int index) throws SQLException {
				T t=null;
				try{
					t=type.newInstance();
					Field[] fields=type.getDeclaredFields();
					for(Field field:fields){
						field.set(t, rs.getObject(field.getName()));
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				return t;
			}
			
		});
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
