package test.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("test")
class TestGroovyController {

	@RequestMapping("hello")
	String hello(){
		return "hello groovy world"
	}
	
	
}
