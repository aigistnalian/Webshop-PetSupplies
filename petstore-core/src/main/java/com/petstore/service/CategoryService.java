package com.petstore.service;

import java.util.List;

import com.petstore.model.bo.ProductCategory;

/**
 * @author analian
 *
 */
public interface CategoryService {

	/**
	 * @param category
	 */
	public void addNewCategory(ProductCategory category);
	/**
	 * @return
	 */
	public List<ProductCategory> findAllCategories();
	/**
	 * @param category
	 */
	public void updateSelectedCategory(ProductCategory category);
	/**
	 * @param id
	 */
	void removeSelectedCategory(ProductCategory category);
	
	
}
