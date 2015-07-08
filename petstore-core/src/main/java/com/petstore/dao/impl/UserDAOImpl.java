package com.petstore.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.UserDAO;
import com.petstore.model.bo.User;

@Stateless
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO  {
	
	@Override
	public boolean getLoginDetails(String user, String password) {
		 Query query = entityManager.createQuery("Select u from User u where u.username = '" + user + "' and u.password = '" + password + "'" );
		 
		 @SuppressWarnings("unchecked")
		List<User> users = (List<User>)query.getResultList();
		 if(users!=null && !users.isEmpty())
	       {
			 return true;
	       }
		 return false;
	    }
}
