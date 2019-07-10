package org.ithang.web.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("code")
public class CodeAction {

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
	
	
}
