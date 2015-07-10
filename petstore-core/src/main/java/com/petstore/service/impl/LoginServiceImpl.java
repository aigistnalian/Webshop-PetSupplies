package com.petstore.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.petstore.constants.Constants;
import com.petstore.dao.UserDAO;
import com.petstore.model.bo.Roles;
import com.petstore.model.bo.User;
import com.petstore.service.LoginService;

/**
 * @author analian
 *
 */
@Stateless
public class LoginServiceImpl implements LoginService{

	@Inject
	UserDAO userDAO;
	
	@Override
	public boolean validateAdminUserLogin(String userId, String password) {
		boolean isUserValid = false; 
		User user = userDAO.getLoginDetails(userId, password);
		if(user!=null){
			if(user.getRoles()!=null && !user.getRoles().isEmpty()){
				for (Roles role : user.getRoles()) {
					if(Constants.ADMIN.equalsIgnoreCase(role.getName())){
						isUserValid = true;
						break;
					}
				}
			}
		}
		return isUserValid;
	}
}
