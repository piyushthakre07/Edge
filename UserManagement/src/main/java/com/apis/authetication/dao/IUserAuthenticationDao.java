package com.apis.authetication.dao;

import com.model.UserMaster;

public interface IUserAuthenticationDao {
	String addUser(UserMaster requestBean);

	UserMaster validateUsernamePassword(String loginName, String password);
}