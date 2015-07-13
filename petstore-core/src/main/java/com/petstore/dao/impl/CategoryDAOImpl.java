/**
 * 
 */
package com.petstore.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.transaction.Transactional;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.petstore.dao.CategoryDAO#fetchAllCategories()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> fetchAllCategories() {
		Query query = entityManager
				.createQuery("select pc from ProductCategory pc");
		List<ProductCategory> categories = query.getResultList();
		System.out.println(categories);

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
				for (Product product : products) {
					query  = entityManager.createQuery("delete from Product where id = " + product.getId() + "");
					query.executeUpdate();
				}
			}
			query = entityManager.createQuery("delete from ProductCategory where id = " + category.getId() + "");
			query.executeUpdate();
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
	}

}
