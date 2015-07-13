/**
 * 
 */
package com.petstore.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.ProductDAO;
import com.petstore.model.bo.Product;

/**
 * @author analian
 *
 */
public class ProductDAOImpl extends AbstractDAO<Integer, Product> implements ProductDAO {

	@Override
	public List<Product> fetchProductDetails() {
		Query query = entityManager.createQuery("select p from Product p");
		@SuppressWarnings("unchecked")
		List<Product> allProducts = query.getResultList();
		return allProducts;
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#addNewProduct(com.petstore.model.bo.Product)
	 */
	@Override
	@Transactional
	public void addNewProduct(Product product) {
		entityManager.persist(product);
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#updateProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#deleteProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void removeProduct(Product product) {
		Query query = entityManager.createQuery("delete from Product where id = " + product.getId() + "");
		query.executeUpdate();
	}

}
