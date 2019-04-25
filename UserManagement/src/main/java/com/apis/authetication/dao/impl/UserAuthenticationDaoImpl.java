package com.apis.authetication.dao.impl;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apis.authetication.dao.IUserAuthenticationDao;
import com.beans.CommonResponseBean;
import com.google.gson.Gson;
import com.model.ProductMaster;
import com.model.UserMaster;

@Repository
public class UserAuthenticationDaoImpl implements IUserAuthenticationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public String addUser(UserMaster user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			return new Gson().toJson(new CommonResponseBean("Successfully added User", "1", ""));
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error", "0", "Error001"));
		}
	}
	
	 @SuppressWarnings("unchecked")
		@Override
		@Transactional
	public UserMaster validateUsernamePassword(String loginId,String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			TypedQuery<UserMaster> query = session.getNamedQuery("findUserMasterByUsernamePassword");
			query.setParameter("loginId", loginId);
			query.setParameter("password", password);
			UserMaster user = query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
}
