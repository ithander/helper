package org.ithang.tools.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {

    private static JdbcTemplate jdbcTemplate;
	
    private static NamedParameterJdbcTemplate namedJdbcTemplate;

    public BaseDao(){}
    
	@Autowired
	public BaseDao(DataSource dataSource){
		BaseDao.jdbcTemplate=new JdbcTemplate(dataSource);
		BaseDao.namedJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}

	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		BaseDao.jdbcTemplate = jdbcTemplate;
	}

	public static NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public static void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		BaseDao.namedJdbcTemplate = namedJdbcTemplate;
	}
	
}
