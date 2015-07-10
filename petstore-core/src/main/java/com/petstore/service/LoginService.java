package com.petstore.service;


/**
 * @author analian
 *
 */

public interface LoginService {

	boolean validateAdminUserLogin(String userId, String password);
	
}
