package com.petstore.service;

import javax.ejb.Stateless;

/**
 * @author analian
 *
 */
@Stateless
public interface LoginService {

	boolean validateAdminUserLogin(String userId, String password);
	
}
