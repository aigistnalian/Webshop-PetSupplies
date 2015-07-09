package com.petstore.model.bo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author analian
 *
 */
@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int parent_category_id;
	 @OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	  private Set<Product> products;
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
	/**
	 * @return the parent_category_id
	 */
	public int getParent_category_id() {
		return parent_category_id;
	}
	/**
	 * @param parent_category_id the parent_category_id to set
	 */
	public void setParent_category_id(int parent_category_id) {
		this.parent_category_id = parent_category_id;
	}
	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	

}
