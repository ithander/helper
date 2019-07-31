package org.ithang.web.sys;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.ithang.service.user.UserService;
import org.ithang.service.user.entity.Role;
import org.ithang.service.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class UserAction {

	@Autowired
	private UserService userService;
	
	 
	 @RequiresUser
	 @RequestMapping(value = "/main")
	 public String main(){
	      return "main";
	 }
	
    
    //数据初始化
    @RequestMapping(value = "/admin/addUser")
    public String addUser(@RequestBody User user){
        int uid = userService.addUser(user);
        return "addUser is ok! \n" + uid;
    }

    //角色初始化
    @RequestMapping(value = "/admin/addRole")
    public String addRole(@RequestBody Role role){
        int rid = userService.addRole(role);
        return "addRole is ok! \n" + rid;
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/admin/create")
    public String create(){
        return "Create success!";
    }
	
}
