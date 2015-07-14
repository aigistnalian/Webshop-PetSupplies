/**
 * 
 */
package com.petstore.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.petstore.constants.Constants;
import com.petstore.dao.AbstractDAO;
import com.petstore.dao.CategoryDAO;
import com.petstore.model.bo.Product;
import com.petstore.model.bo.ProductCategory;

/**
 * @author analian
 *
 */
public class CategoryDAOImpl extends AbstractDAO<Integer, ProductCategory>
		implements CategoryDAO {

	final static Logger log = Logger.getLogger(CategoryDAOImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.petstore.dao.CategoryDAO#fetchAllCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> fetchAllCategories() {
		log.info("creating query for fetching all categories");
		
		Query query = entityManager.createQuery("select pc from ProductCategory pc");
		List<ProductCategory> categories = query.getResultList();
		
		log.info("fetched all categories" + categories);
		return categories;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.petstore.dao.CategoryDAO#addNewCategory(com.petstore.model.bo.
	 * ProductCategory)
	 */
	@Override
	@Transactional
	public void addNewCategory(ProductCategory category) {
		log.info("DAO Class --> Adding new category");
		entityManager.persist(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.petstore.dao.CategoryDAO#removeCategory(com.petstore.model.bo.
	 * ProductCategory)
	 */
	@Override
	@Transactional
	public void removeCategory(ProductCategory category) {
		Query query =null;
		try {
			Set<Product> products =  category.getProducts();
			if(products!=null){
				log.debug("Category has products in it" + products);
				for (Product product : products) {
					query  = entityManager.createQuery(Constants.DELETE_PRODUCT_SQL_STRING + product.getId() + "");
					query.executeUpdate();
				}
				log.debug("Removed associated products");
			}
			query = entityManager.createQuery( Constants.DELETE_CATEGORY_SQL_STRING + category.getId() + "");
			query.executeUpdate();
			log.debug("deleted category");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.petstore.dao.CategoryDAO#updateCategory(com.petstore.model.bo.
	 * ProductCategory)
	 */
	@Override
	@Transactional
	public void updateCategory(ProductCategory category) {
		entityManager.merge(category);
		log.debug("Updated category" + category);
	}

}
