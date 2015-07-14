/**
 * 
 */
package com.petstore.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.petstore.constants.Constants;
import com.petstore.dao.AbstractDAO;
import com.petstore.dao.ProductDAO;
import com.petstore.model.bo.Product;

/**
 * @author analian
 *
 */
public class ProductDAOImpl extends AbstractDAO<Integer, Product> implements ProductDAO {

	final static Logger log = Logger.getLogger(ProductDAOImpl.class);
	
	@Override
	public List<Product> fetchProductDetails() {
		log.info("creating SQL Query for selecting all products");
		Query query = entityManager.createQuery(Constants.SELECT_PRODUCT_SQL_STRING);
		@SuppressWarnings("unchecked")
		List<Product> allProducts = query.getResultList();
		log.info("returning list of all products" + allProducts);
		return allProducts;
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#addNewProduct(com.petstore.model.bo.Product)
	 */
	@Override
	@Transactional
	public void addNewProduct(Product product) {
		log.debug("Adding new product -->" + product);
		entityManager.persist(product);
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#updateProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void updateProduct(Product product) {
		log.debug("Updating product " + product);
		entityManager.merge(product);
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#deleteProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void removeProduct(Product product) {
		log.debug("Removing product -->" + product);
		Query query = entityManager.createQuery(Constants.DELETE_PRODUCT_SQL_STRING + product.getId() + "");
		query.executeUpdate();
	}

}
