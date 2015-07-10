package com.petstore.admin.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.petstore.admin.bean.CategoryBean;
import com.petstore.admin.bean.CategoryItem;
import com.petstore.constants.Constants;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * @author analian
 *
 */
@ManagedBean(name="categoryController")
@SessionScoped
public class CategoryController {

	@Inject
	CategoryService categoryService;
	
	@ManagedProperty(value = "#{categoryItem}")
	private CategoryItem categoryItem;
	
	/**
	 * @return
	 */
	public String addNewCategory() {
		CategoryBean bean = new CategoryBean(categoryItem.getCategoryName(),
				categoryItem.getDescription());
		categoryItem.getCatList().add(bean);
		
		ProductCategory category = new ProductCategory();
		category.setName(categoryItem.getCategoryName());
		category.setDescription(categoryItem.getDescription());
		
		categoryService.addNewCategory(category);
		
		categoryItem.setCategoryName(Constants.EMPTY);
		categoryItem.setDescription(Constants.EMPTY);
		return null;
	}

	/**
	 * @return the categoryItem
	 */
	public CategoryItem getCategoryItem() {
		return categoryItem;
	}

	/**
	 * @param categoryItem the categoryItem to set
	 */
	public void setCategoryItem(CategoryItem categoryItem) {
		this.categoryItem = categoryItem;
	}
}
