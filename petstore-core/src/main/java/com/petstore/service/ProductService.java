package com.petstore.service;

import java.util.List;

import com.petstore.model.bo.Product;


/**
 * @author analian
 *
 */
public interface ProductService {

	/**
	 * @return
	 */
	public List<Product> fetchAllProductDetails();
	
	/**
	 * @param product
	 */
	public void addNewProduct(Product product);
	
	/**
	 * @param product
	 */
	public void updateProduct(Product product);
	
	/**
	 * @param product
	 */
	public void removeSelectedProduct(Product product);
	
}
