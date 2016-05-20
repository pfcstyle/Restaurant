package com.pfc.service;

import java.util.ArrayList;
import com.pfc.util.DaoFactory;
import com.pfc.dao.IUserDAO;
import com.pfc.domain.User;

public class UserServiceImpl implements UserService {

	public boolean validateUser(String username, String pwd) {
		IUserDAO userdao = (IUserDAO) DaoFactory.newInstance("IUserDAO");
		User user = userdao.findUser(username,pwd);
		System.out.println(user.getuserid()+"");
		if(user!=null){
			return true;
		}
		return false;
	}

}
