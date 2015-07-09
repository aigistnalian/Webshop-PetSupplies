package com.petstore.admin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.petstore.constants.Constants;

@ManagedBean(name = "item")
@SessionScoped
public class ProductItem implements Serializable {

   private static final long serialVersionUID = 1L;
   private String item;
   private String description;
   private Double price;
   ProductBean product;
   private String category; 
   private Map<String,String> categories;
   
   
   @PostConstruct
   public void init() {
	   categories = new HashMap<String, String>();
	   categories.put("a", "FOOD");
	   categories.put("b", "TOYS");
	   categories.put("c", "COLLARS");
	   categories.put("d", "TAGS");
   }
   
   public void onCategoryChange(){
	   System.out.println(category);
   }
   
   public String getItem() {
       return item;
   }

   public void setItem(String item) {
       this.item = item;
   }

   public Double getPrice() {
       return price;
   }

   public void setPrice(Double price) {
       this.price = price;
   }

   private static final ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

   public ArrayList<ProductBean> getProductList() {
       return productList;
   }

   public String addAction() {
       ProductBean productItem = new ProductBean(this.item, this.description, this.price);
       productList.add(productItem);

       item = Constants.EMPTY;
       price = 0.0;
       description = Constants.EMPTY;
       return null;
   }
   public void onEdit(RowEditEvent event) {  
       FacesMessage msg = new FacesMessage("Item Edited",((ProductBean) event.getObject()).getItem());  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
   }  
      
   public void onCancel(RowEditEvent event) {  
       FacesMessage msg = new FacesMessage("Item Cancelled");   
       FacesContext.getCurrentInstance().addMessage(null, msg); 
       productList.remove((ProductBean) event.getObject());
   }

/**
 * @return the category
 */
public String getCategory() {
	return category;
}

/**
 * @param category the category to set
 */
public void setCategory(String category) {
	this.category = category;
}

/**
 * @return the categories
 */
public Map<String, String> getCategories() {
	return categories;
}

/**
 * @param categories the categories to set
 */
public void setCategories(Map<String, String> categories) {
	this.categories = categories;
}

/**
 * @return the description
 */
public String getDescription() {
	return description;
}

/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}

/**
 * @return the product
 */
public ProductBean getProduct() {
	return product;
}

/**
 * @param product the product to set
 */
public void setProduct(ProductBean product) {
	this.product = product;
}  
   
}