package com.apis.authetication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apis.authetication.service.IUserAuthenticationService;
import com.beans.CommonResponseBean;
import com.beans.UserBean;
import com.google.gson.Gson;

@RestController
public class UserAuthenticationController {
	@Autowired
	IUserAuthenticationService userAuthentication;

	/**
	 * @param requestBean
	 * @return String in Json format
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody UserBean requestBean) {
		try {
			String response = userAuthentication.addUser(requestBean);
			return response;
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR100"));
		}
	}

	@RequestMapping(value = "/userauthentication", method = RequestMethod.POST)
	public @ResponseBody String userAuthentication(@RequestBody UserBean requestBean) {
		try {
			String response = userAuthentication.validateUsernamePassword(requestBean.getLoginName(),
					requestBean.getPassword());
			return response;
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR100"));
		}
	}

}
