package org.ithang.service.logic_sql;

import java.util.List;

import org.ithang.service.logic_sql.entity.LogicSQL;
import org.ithang.tools.dao.MService;
import org.ithang.tools.dao.QueryResult;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑SQL
 * @author zyt
 *
 */
@Service
public class LogicSQLService extends MService<LogicSQL>{

	/**
	 * 综合查询相关数据
	 * @param logicSQL
	 * @return
	 */
	public List<LogicSQL> query(LogicSQL logicSQL){
		return query(LogicSQLTemplate.getQuerySQL(), logicSQL.bindata());
	}
	
	/**
	 * 综合查询相关数据带分页
	 * @param logicSQL
	 * @return
	 */
	public QueryResult<LogicSQL> query(LogicSQL logicSQL,int pageIndex,int pageSize){
		return query(LogicSQLTemplate.getQuerySQL(), logicSQL.bindata(),pageIndex<=0?1:pageIndex,pageSize<=0?15:pageSize);
	}
	
	
}
