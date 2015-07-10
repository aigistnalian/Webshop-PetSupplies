package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

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

	CategoryBean categoryBean;

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
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited",
				((CategoryBean) event.getObject()).getCategoryName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		
		CategoryBean categoryBean = (CategoryBean) event.getObject();
		ProductCategory pc = new ProductCategory();
		pc.setId(categoryBean.getId());
		pc.setName(categoryBean.getCategoryName());
		pc.setDescription(categoryBean.getDescription());
		pc.setProducts(categoryBean.getProducts());
		
		categoryService.removeSelectedCategory(pc);
		
		catList.remove((CategoryBean) event.getObject());
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
	 * @return the categoryBean
	 */
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	/**
	 * @param categoryBean
	 *            the categoryBean to set
	 */
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
