package com.petstore.admin.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

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
@RequestScoped
public class CategoryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -193807208415040894L;

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
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited",
				((CategoryBean) event.getObject()).getCategoryName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		ProductCategory pc = mapBeanToBo(event);
		categoryService.updateSelectedCategory(pc);
	}

	/**
	 * @param event
	 */
	public void onCancel(RowEditEvent cancelEvent) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		CategoryBean categoryBean = (CategoryBean)((DataTable)cancelEvent.getSource()).getRowData();
		ProductCategory pc = mapBeanToBo(cancelEvent);
		categoryService.removeSelectedCategory(pc);
		
		categoryItem.getCatList().remove(categoryBean);
		
	}


	/**
	 * @param event
	 * @return
	 */
	private ProductCategory mapBeanToBo(RowEditEvent event) {
		DataTable dataTable = (DataTable)event.getSource();
		System.out.println(dataTable.getRowData());
		CategoryBean categoryBean = (CategoryBean)dataTable.getRowData();
		ProductCategory pc = new ProductCategory();
		pc.setId(categoryBean.getId());
		pc.setName(categoryBean.getCategoryName());
		pc.setDescription(categoryBean.getDescription());
		pc.setProducts(categoryBean.getProducts());
		return pc;
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


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
