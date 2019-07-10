package org.ithang.tools.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ithang.service.kvalues.KValuesService;
import org.ithang.service.logic_sql.LogicSQLService;
import org.ithang.service.logic_sql.entity.LogicSQL;
import org.ithang.tools.dao.MySQL;
import org.ithang.tools.gener.MySQLGener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class InitApp implements ApplicationRunner{

	@Autowired
	private KValuesService kvaluesService;
	
	@Autowired
	private LogicSQLService logicSQLService;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		List<LogicSQL> logicSQLs=logicSQLService.list();
		if(null!=logicSQLs&&!logicSQLs.isEmpty()){
			for(LogicSQL logicSQL:logicSQLs){
				MySQL.addSQL(logicSQL.getKey(), logicSQL.getContent());
			}
		}
		/*String sql=MySQL.getBeansSQL("selectUserByWhere");
		Map<String,Object> mp=new HashMap<>();
		mp.put("uid", 123);
		List<String> as=new ArrayList<>();
		as.add("aaaa");
		as.add("bbbb");
		mp.put("fields", as);
		System.out.println(MySQLGener.process(sql,mp));*/
	}

}
