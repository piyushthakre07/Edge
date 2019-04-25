package com.apis.authetication.service;

import com.beans.UserBean;

public interface IUserAuthenticationService {
	String addUser(UserBean requestBean);
	
	String validateUsernamePassword(String loginName, String password);
}
