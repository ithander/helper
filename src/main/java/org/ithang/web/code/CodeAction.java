package org.ithang.web.code;

import org.ithang.service.engine.APIService;
import org.ithang.service.engine.entity.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("code")
public class CodeAction {

	@Autowired
	private APIService apiService;
	
	@RequestMapping("sidemenus")
	public String sidemenus(){
		return "code/sidemenus";
	}
	
	@RequestMapping("beans")
	public String beans(){
		return "code/sidemenus";
	}
	
	@RequestMapping("mappers")
	public String mappers(){
		return "code/sidemenus";
	}
	
	@RequestMapping("xmls")
	public String xmls(){
		return "code/sidemenus";
	}
	
	@RequestMapping("apis")
	public String apis(){
		return "code/apis";
	}
	
	@RequestMapping("api/insert")
	public void insertAPI(API api){
		apiService.insert(api);
	}
	
	@RequestMapping("api/update")
	public void updateAPI(API api){
		apiService.update(api);
	}
	
	
}
