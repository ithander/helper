package org.ithang.tools.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

@Order(1)
public class InitApp implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("run init app....");		
	}

}
