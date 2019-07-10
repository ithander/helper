package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.ithang.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Bootstrap.class})
public class SpringBootJdbcApplicationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
    public void testOne(){
		final CountDownLatch countDownLatch = new CountDownLatch(100);
		final CountDownLatch countDownLatch2 = new CountDownLatch(100);
		
		ExecutorService executorService = Executors.newFixedThreadPool(100);
	
		for(int i=0;i<100;i++){
			executorService.submit(new Runnable(){

				@Override
				public void run() {
					try{
						countDownLatch.await();
					}catch(Exception e){e.printStackTrace();}
					
					//synchronized (jdbcTemplate) {
						//int count=jdbcTemplate.queryForObject("select count(0) from user_info where id=1", Integer.class);
						//if(0==count){
							//jdbcTemplate.update("insert into user_info(uname,score)values('testa',1)");
						//}else{
							jdbcTemplate.update("update user_info set score=score+1 where id=1");
						//}
					//}
					
					countDownLatch2.countDown();
				}
			});
			countDownLatch.countDown();
			
		}
		
		
		try{
		    countDownLatch2.await();//保证所有线程执行完
		}catch(Exception e){e.printStackTrace();}
		executorService.shutdown();
		
		
    }
	
}
