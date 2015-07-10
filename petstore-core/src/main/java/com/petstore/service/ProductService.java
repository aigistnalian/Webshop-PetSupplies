package com.petstore.service;

import java.util.List;

import com.petstore.model.bo.Product;


public interface ProductService {

	public List<Product> fetchAllProductDetails();
	
	public void addNewProduct(Product product);
}
