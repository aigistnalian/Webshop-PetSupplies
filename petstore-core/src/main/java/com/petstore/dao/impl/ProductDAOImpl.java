/**
 * 
 */
package com.petstore.dao.impl;

import com.petstore.dao.AbstractDAO;
import com.petstore.dao.ProductDAO;
import com.petstore.model.bo.Product;

/**
 * @author analian
 *
 */
public class ProductDAOImpl extends AbstractDAO<Integer, Product> implements ProductDAO {

	@Override
	public Product fetchProductDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#addNewProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void addNewProduct(Product product) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#updateProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.petstore.dao.ProductDAO#deleteProduct(com.petstore.model.bo.Product)
	 */
	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}

}
