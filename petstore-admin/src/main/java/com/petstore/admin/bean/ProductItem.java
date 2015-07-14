package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.petstore.model.bo.Product;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;
import com.petstore.service.ProductService;

@ManagedBean(name = "item")
@RequestScoped
public class ProductItem implements Serializable 
{
	@Inject
	ProductService productService;
	
	@Inject
	CategoryService categoryService;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String item;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Double price;
	/**
	 * 
	 */
	private String category;

	/**
	 * 
	 */
	private Map<Integer, String> categories;

	/**
	 * 
	 */
	private ArrayList<ProductBean> productList = new ArrayList<ProductBean>();


	
	/**
	 * 
	 */
	@PostConstruct
	public void init() 
	{
		this.refreshProductList();
		this.categories = new HashMap<Integer, String>();
		List<ProductCategory> categoriesList = categoryService.findAllCategories();
		for (ProductCategory productCategory : categoriesList) 
		{
			categories.put(productCategory.getId(), productCategory.getName());
		}
	}

	/**
	 * 
	 */
	public void refreshProductList() 
	{
		List<Product> productsList = productService.fetchAllProductDetails();
		System.out.println(productsList);

		productList.clear();

		for (Product product : productsList) 
		{
			ProductBean pBean = new ProductBean(product.getName(),
					product.getDescription(), product.getPrice().doubleValue());
			pBean.setId(product.getId());
			pBean.setPcId(product.getProduct_category_id());
			pBean.setSku(product.getSku());
			productList.add(pBean);
		}
	}

	/**
	 * 
	 */
	public void onCategoryChange() 
	{
		System.out.println(category);
	}

	/**
	 * @return
	 */
	public String getItem() 
	{
		return item;
	}

	/**
	 * @param item
	 */
	public void setItem(String item) 
	{
		this.item = item;
	}

	/**
	 * @return
	 */
	public Double getPrice() 
	{
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(Double price) 
	{
		this.price = price;
	}

	

	/**
	 * @return
	 */
	public ArrayList<ProductBean> getProductList() 
	{
		if (this.productList == null) 
		{
			refreshProductList();
		}
		return productList;
	}

	/**
	 * @return the category
	 */
	public String getCategory() 
	{
		return this.category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) 
	{
		this.category = category;
	}

	/**
	 * @return the categories
	 */
	public Map<Integer, String> getCategories() 
	{
		categories = new HashMap<Integer, String>();
		List<ProductCategory> categoriesList = categoryService
				.findAllCategories();
		for (ProductCategory productCategory : categoriesList)
		{
			categories.put(productCategory.getId(), productCategory.getName());
		}
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(Map<Integer, String> categories) 
	{
		this.categories = categories;
	}

	/**
	 * @return the description
	 */
	public String getDescription() 
	{
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

}