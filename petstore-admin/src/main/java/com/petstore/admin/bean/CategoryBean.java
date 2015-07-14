package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.Set;

import com.petstore.model.bo.Product;

/**
 * @author analian
 *
 */
public class CategoryBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7613789070799055414L;
	
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String categoryName;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	Set<Product> products;
	
	/**
	 * @param categoryName
	 * @param description
	 */
	public CategoryBean(String categoryName, String description) 
	{
		this.categoryName = categoryName;
		this.description = description;
	}
	
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() 
	{
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}
	/**
	 * @param description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * @return
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * @return the id
	 */
	public int getId() 
	{
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() 
	{
		return this.products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) 
	{
		this.products = products;
	}


}
