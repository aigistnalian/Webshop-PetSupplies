package com.petstore.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.UserDAO;
import com.petstore.model.bo.User;

public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO  {
	
	final static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public User getLoginDetails(String user, String password) {
		 Query query = entityManager.createQuery("Select u from User u where u.username = '" 
				 						+ user + "' and u.password = '" + password + "'" );
		 log.debug("Login validation");
		 @SuppressWarnings("unchecked")
		List<User> users = (List<User>)query.getResultList();
		 if(users!=null && !users.isEmpty())
	       {
			 if(users.size()==1)
			 {
				 return users.get(0);
			 }
	       }
		 return null;
	    }
}
