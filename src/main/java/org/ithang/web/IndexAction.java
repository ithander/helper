package org.ithang.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexAction {

	
	@RequestMapping("left")
	public String left(){
		return "left";
	}
	
	
	//退出的时候是get请求，主要是用于退出
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
    	Subject subject = SecurityUtils.getSubject();
    	if(subject.isRemembered()||subject.isAuthenticated()){
        	return "main";
        }
        return "login";
    }
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String uname,@RequestParam String upass,@RequestParam(defaultValue="0",required=false) String remeber){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        if(subject.isRemembered()||subject.isAuthenticated()){
        	return "main";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(uname,upass);
        if("1".equals(remeber)){
        	usernamePasswordToken.setRememberMe(true);	
        }
        
        //进行验证，这里可以捕获异常，然后返回对应信息
        try{
            subject.login(usernamePasswordToken);
            return "main";
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return "login";
    }
	
	
	//登出
    @RequestMapping(value = "/logout")
    public String logout(){
    	Subject subject = SecurityUtils.getSubject();
        if(null!=subject){
        	subject.logout();
        }
        return "index";
    }
	
	
}
