package test;
import org.ithang.service.user.entity.User;
public class Hello {

	public static void hello(){
		User u=new User();
		u.setUname("goodeeeee");
		System.out.println(" Hello "+u.getUname());
	}

}
