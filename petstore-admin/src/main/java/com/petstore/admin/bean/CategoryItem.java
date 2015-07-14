package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * @author analian
 *
 */
@ManagedBean(name = "categoryItem")
@RequestScoped
public class CategoryItem implements Serializable 
{
	/**
	 * 
	 */
	@Inject
	CategoryService categoryService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String categoryName;
	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private  ArrayList<CategoryBean> catList = new ArrayList<CategoryBean>();


	/**
	 * 
	 */
	@PostConstruct
	public void init() 
	{
		this.refreshCategories();
	}

	/**
	 * 
	 */
	private void refreshCategories() 
	{
		List<ProductCategory> categoriesList = categoryService.findAllCategories();
		this.catList.clear();
		
		if (categoriesList != null) 
		{
			for (ProductCategory productCategory : categoriesList) 
			{
				CategoryBean bean = new CategoryBean(productCategory.getName(),
						productCategory.getDescription());
				bean.setId(productCategory.getId());
				bean.setProducts(productCategory.getProducts());
				this.catList.add(bean);
			}
		}
	}


	/**
	 * @return
	 */
	public ArrayList<CategoryBean> getCatList() 
	{
		return this.catList;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() 
	{
		return this.categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * @return
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}
}
