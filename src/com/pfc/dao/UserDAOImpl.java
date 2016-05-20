package com.pfc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pfc.domain.User;
import com.pfc.util.JDBCUtil;



public class UserDAOImpl extends baseDAO implements IUserDAO {


	public ArrayList findUsers() {
		String sql = "select * from userinfo";
		return findObjs(sql,null,User.class);
	}


	public int insertUser(User user) {
		String sql = "insert into userinfo (loginname,loginpwd) values(?,?)";
		Object[] params = {user.getusername(),user.getpassword()};
		return updateObj(sql, params);

	}
	
	
	public int updateUser(User user) {
		String sql = "update userinfo set loginpwd=? where userid=?";
		Object[] params = {user.getpassword(),user.getuserid()};
		return updateObj(sql, params);
	}

	
	public int deleteUser(int userId) {
		String sql2 = "delete from userinfo where userid =?";
		Object[] params = {userId};
		return updateObj(sql2, params);
	}

	
	public User findUser(String loginName,String loginPwd) {
		String sql = "select userid userid,loginname username,loginpwd password from userinfo where loginname=? and loginpwd=? ";
		Object[] params={loginName,loginPwd};
		return (User)findObj(sql,params,User.class);
	}

}
