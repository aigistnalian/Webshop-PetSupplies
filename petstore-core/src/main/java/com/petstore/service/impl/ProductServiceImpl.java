/**
 * 
 */
package com.petstore.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.petstore.dao.ProductDAO;
import com.petstore.model.bo.Product;
import com.petstore.service.ProductService;

/**
 * @author analian
 *
 */
@Stateless
public class ProductServiceImpl implements ProductService {

	
	@Inject
	ProductDAO productDAO;
	
	@Override
	public List<Product> fetchAllProductDetails() {
		return productDAO.fetchProductDetails();
	}

	@Override
	@Transactional
	public void addNewProduct(Product product) {
		productDAO.addNewProduct(product);
	}

}
