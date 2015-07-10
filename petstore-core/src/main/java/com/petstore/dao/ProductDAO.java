package com.petstore.dao;

import java.util.List;

import com.petstore.model.bo.Product;

public interface ProductDAO  extends DAO<Integer, Product>{
	
	public List<Product> fetchProductDetails();
	
	public void addNewProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void removeProduct(Product product);

}
