package test;

import org.ithang.Bootstrap;
import org.ithang.service.logic_sql.LogicSQLService;
import org.ithang.service.logic_sql.entity.LogicSQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Bootstrap.class})
public class BeanServiceTest {

	@Autowired
	private LogicSQLService logicSQLService;
	
	@Test
	public void add(){
		LogicSQL logicSQL=new LogicSQL();
		logicSQL.setKey("test");
		logicSQL.setContent("select * from test ");
		logicSQLService.insert(logicSQL);
	}
	
	@Test
	public void del(){
		
	}
	
	@Test
	public void update(){
		
	}
	
	@Test
	public void query(){
		
	}
	
	@Test
	public void queryByPage(){
		
	}
	
}
