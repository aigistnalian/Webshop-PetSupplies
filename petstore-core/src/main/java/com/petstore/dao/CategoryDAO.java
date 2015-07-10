/**
 * 
 */
package com.petstore.dao;

import java.util.List;

import com.petstore.model.bo.ProductCategory;

/**
 * @author analian
 *
 */
public interface CategoryDAO extends DAO<Integer, ProductCategory> {

	/**
	 * @return
	 */
	public List<ProductCategory> fetchAllCategories();
	/**
	 * @param category
	 */
	public void addNewCategory(ProductCategory category);
	/**
	 * @param category
	 */
	public void removeCategory(ProductCategory category);
	/**
	 * @param category
	 */
	public void updateCategory(ProductCategory category);
}
