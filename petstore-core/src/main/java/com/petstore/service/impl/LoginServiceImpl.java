package com.petstore.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

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

	final static Logger log = Logger.getLogger(LoginServiceImpl.class);
	
	@Inject
	UserDAO userDAO;
	
	@Override
	public boolean validateAdminUserLogin(String userId, String password) {
		boolean isUserValid = false; 
		User user = userDAO.getLoginDetails(userId, password);
		log.debug("Getting the user for -->" + userId);
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
		log.debug("returning after login -->"+ isUserValid);
		return isUserValid;
	}
}
