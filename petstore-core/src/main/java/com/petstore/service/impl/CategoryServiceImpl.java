/**
 * 
 */
package com.petstore.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.petstore.dao.CategoryDAO;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * @author analian
 *
 */
@Stateless
public class CategoryServiceImpl implements CategoryService {

	@Inject
	CategoryDAO categoryDAO;
	
	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#addNewCategory(com.petstore.model.bo.ProductCategory)
	 */
	@Override
	public void addNewCategory(ProductCategory category) {
		categoryDAO.addNewCategory(category);
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#findAllCategories()
	 */
	@Override
	public List<ProductCategory> findAllCategories() {
		return categoryDAO.fetchAllCategories();
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#removeSelectedCategory(com.petstore.model.bo.ProductCategory)
	 */
	@Override
	public void removeSelectedCategory(ProductCategory category) {
		categoryDAO.removeCategory(category);
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#updateSelectedCategory(com.petstore.model.bo.ProductCategory)
	 */
	@Override
	public void updateSelectedCategory(ProductCategory category) {
		categoryDAO.updateCategory(category);
	}

}
