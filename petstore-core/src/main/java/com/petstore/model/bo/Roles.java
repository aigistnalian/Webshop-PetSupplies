/**
 * 
 */
package com.petstore.model.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author analian
 *
 */
@Entity
@Table(name="ROLES")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2116538630796593082L;

	@Id
	private int id;
	
	private String name;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
