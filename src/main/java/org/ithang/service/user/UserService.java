package org.ithang.service.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ithang.service.user.entity.Role;
import org.ithang.service.user.entity.User;
import org.ithang.tools.dao.BaseDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseDao{

	public User findByName(String uname){
		User user=getJdbcTemplate().queryForObject("select id,uname,upass,title,email,create_time from user_info where uname=?", new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg) throws SQLException {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setUpass(rs.getString("upass"));
				u.setTitle(rs.getString("title"));
				u.setEmail(rs.getString("email"));
				u.setCreate_time(rs.getString("create_time"));
				return u;
			}
			
		},uname);
		
		return user;
	}
	
	public int addUser(User user){
		return 0;
	}
	
	public int addRole(Role role){
		return 0;
	}
	
}
