package com.pfc.dao;
import java.util.ArrayList;

import com.pfc.domain.User;


public interface IUserDAO {
	public ArrayList findUsers();
	public User findUser(String loginName,String loginPwd);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(int userId);
}
