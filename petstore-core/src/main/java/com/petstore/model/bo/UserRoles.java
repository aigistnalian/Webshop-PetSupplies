package com.petstore.model.bo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author analian
 *
 */
@Entity
@Table(name="USER_ROLES")
public class UserRoles {
	
	private int user_id;
	
	private int role_id;

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	

}
