package com.petstore.service.impl;

import javax.inject.Inject;

import com.petstore.dao.UserDAO;
import com.petstore.service.LoginService;

/**
 * @author analian
 *
 */
public class LoginServiceImpl implements LoginService{

	@Inject
	UserDAO userDAO;
	
	@Override
	public boolean validateUserLogin(String userId, String password) {
		boolean isUserValid = userDAO.getLoginDetails(userId, password);
		return isUserValid;
	}
}
