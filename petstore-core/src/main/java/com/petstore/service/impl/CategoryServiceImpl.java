/**
 * 
 */
package com.petstore.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.petstore.dao.CategoryDAO;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * @author analian
 *
 */
@Stateless
public class CategoryServiceImpl implements CategoryService {

	final static Logger log = Logger.getLogger(CategoryServiceImpl.class);
	
	@Inject
	CategoryDAO categoryDAO;
	
	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#addNewCategory(com.petstore.model.bo.ProductCategory)
	 */
	@Override
	public void addNewCategory(ProductCategory category) {
		log.info("Adding New Category -->" + category.getName());
		categoryDAO.addNewCategory(category);
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#findAllCategories()
	 */
	@Override
	public List<ProductCategory> findAllCategories() {
		log.info("fetching all categories");
		return categoryDAO.fetchAllCategories();
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#removeSelectedCategory(com.petstore.model.bo.ProductCategory)
	 */
	@Override
	public void removeSelectedCategory(ProductCategory category) {
		log.info("Removing Category -->" + category.getName());
		categoryDAO.removeCategory(category);
	}

	/* (non-Javadoc)
	 * @see com.petstore.service.CategoryService#updateSelectedCategory(com.petstore.model.bo.ProductCategory)
	 */
	@Override
	public void updateSelectedCategory(ProductCategory category) {
		log.info("Updating the Category -->" + category.getName());
		categoryDAO.updateCategory(category);
	}

}
