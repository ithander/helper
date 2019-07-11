package org.ithang.tools.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ithang.tools.gener.MySQLGener;
import org.springframework.jdbc.core.RowMapper;

public class MService<T> extends BaseDao<T> {

	private static Logger logger=Logger.getLogger(MService.class);
	
	@SuppressWarnings("unchecked")
	public List<T> query(String SQLTemplate,Map<String,Object> bindData){
		final Class<T> type=(Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		getJdbcTemplate().query(MySQLGener.process(SQLTemplate, bindData),new RowMapper<T>(){

			@Override
			public T mapRow(ResultSet rs, int index) throws SQLException {
				T t=null;
				try{
					t=type.newInstance();
					Field[] fields=type.getDeclaredFields();
					for(Field field:fields){
						field.setAccessible(true);
						field.set(t, rs.getObject(field.getName()));
					}
				}catch(Exception e){
					logger.error(e.getMessage());
					e.printStackTrace();
					
				}
				
				return t;
			}
			
		});
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public QueryResult<T> query(String SQLTemplate,Map<String,Object> bindData,int pageIndex,int pageSize){
		
		QueryResult<T> qr=new QueryResult<>();
		
		String sql=MySQLGener.process(SQLTemplate, bindData);
		long total=getJdbcTemplate().queryForObject("select count(0) from ( "+sql+" ) a", Long.class);
		
		qr.setTotal(total);//设置总记录数
		
		final Class<T> type=(Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		List<T> data=getJdbcTemplate().query(sql,new RowMapper<T>(){

			@Override
			public T mapRow(ResultSet rs, int index) throws SQLException {
				T t=null;
				try{
					t=type.newInstance();
					Field[] fields=type.getDeclaredFields();
					for(Field field:fields){
						field.setAccessible(true);
						field.set(t, rs.getObject(field.getName()));
					}
				}catch(Exception e){
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				
				return t;
			}
			
		});
		
		qr.setData(data);//设置数据
		
		return qr;
	}
	
	
}
