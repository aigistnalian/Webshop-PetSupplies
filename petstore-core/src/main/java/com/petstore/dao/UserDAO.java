package com.petstore.dao;

import com.petstore.model.bo.User;

public interface UserDAO extends DAO<Integer, User> {

	boolean getLoginDetails(String user, String password);
}
