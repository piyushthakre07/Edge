package com.apis.authetication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.authetication.dao.IUserAuthenticationDao;
import com.apis.authetication.service.IUserAuthenticationService;
import com.beans.CommonResponseBean;
import com.beans.UserBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.ProductMaster;
import com.model.UserMaster;

@Service
public class UserAuthenticationServiceImpl implements IUserAuthenticationService {
	@Autowired
	IUserAuthenticationDao userAuthenticationDao;

	@Override
	public String addUser(UserBean requestBean) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			UserMaster userMaster = mapper.convertValue(requestBean, UserMaster.class);
			String response = userAuthenticationDao.addUser(userMaster);
			return response;
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR100"));
		}
	}

	@Override
	public String validateUsernamePassword(String loginName, String password) {
		try {
			UserMaster user=userAuthenticationDao.validateUsernamePassword(loginName, password);
			if(user!=null) {
				return new Gson().toJson(new CommonResponseBean("User "+user.getFirstName()+" Successfully Login.", "1", null));
			}else {
				return new Gson().toJson(new CommonResponseBean("Authentication Fail", "0", "Auth001"));
			}
		}catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR100"));
		}
	}

}
