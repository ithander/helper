package org.ithang.tools.init;

import java.util.List;

import org.ithang.service.kvalues.KValuesService;
import org.ithang.service.kvalues.entity.KValues;
import org.ithang.tools.lang.JsonUtils;
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
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		List<KValues> values=kvaluesService.list();
		System.out.println(JsonUtils.toJsonStr(values));
	}

}
