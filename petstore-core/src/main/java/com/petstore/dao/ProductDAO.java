package com.petstore.dao;

import com.petstore.model.bo.Product;

public interface ProductDAO  extends DAO<Integer, Product>{
	
	public Product fetchProductDetails();
	
	public void addNewProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);

}
