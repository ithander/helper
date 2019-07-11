package test;

import java.util.HashMap;
import java.util.Map;

import org.ithang.service.logic_sql.LogicSQLTemplate;
import org.ithang.service.logic_sql.entity.LogicSQL;
import org.ithang.tools.gener.MySQLGener;
import org.junit.Test;

public class MySQLGenerTest {

	
	@Test
	public void testProcess(){
		Map<String,Object> bind=new HashMap<>();
		bind.put("key", "abc");
		bind.put("content", "good job");
		bind.put("opt", null);
		
		LogicSQL logicSQL=new LogicSQL();
		logicSQL.setKey("abc");
		
		String s=MySQLGener.process(LogicSQLTemplate.getQuerySQL(), logicSQL.bindata());
		System.out.println(s);
	}
}
