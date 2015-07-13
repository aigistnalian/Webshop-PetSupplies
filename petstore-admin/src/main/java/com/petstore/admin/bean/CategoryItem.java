package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;

/**
 * @author analian
 *
 */
@ManagedBean(name = "categoryItem")
@SessionScoped
public class CategoryItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private String categoryName;
	private String description;

	@Inject
	CategoryService categoryService;

	@PostConstruct
	public void init() {
		List<ProductCategory> categoriesList = categoryService.findAllCategories();
		catList.clear();
		System.out.println(categoriesList);
		
		if (categoriesList != null) {
			for (ProductCategory productCategory : categoriesList) {
				CategoryBean bean = new CategoryBean(productCategory.getName(),
						productCategory.getDescription());
				bean.setId(productCategory.getId());
				bean.setProducts(productCategory.getProducts());
				catList.add(bean);
			}
		}
	}

	/**
	 * 
	 */
	private static final ArrayList<CategoryBean> catList = new ArrayList<CategoryBean>();

	/**
	 * @return
	 */
	public ArrayList<CategoryBean> getCatList() {
		return catList;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
