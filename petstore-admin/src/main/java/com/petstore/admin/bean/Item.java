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

@ManagedBean(name = "item")
@SessionScoped
public class Item implements Serializable {

   private static final long serialVersionUID = 1L;
   private String item;
   private String description;
   private Double price;
   OrderBean order;
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

   public OrderBean getOrder() {
       return order;
   }

   public void setOrder(OrderBean order) {
       this.order = order;
   }
   private static final ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();

   public ArrayList<OrderBean> getOrderList() {
       return orderList;
   }

   public String addAction() {
       OrderBean orderitem = new OrderBean(this.item, this.description, this.price);
       orderList.add(orderitem);

       item = "";
       price = 0.0;
       description = "";
       return null;
   }
   public void onEdit(RowEditEvent event) {  
       FacesMessage msg = new FacesMessage("Item Edited",((OrderBean) event.getObject()).getItem());  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
   }  
      
   public void onCancel(RowEditEvent event) {  
       FacesMessage msg = new FacesMessage("Item Cancelled");   
       FacesContext.getCurrentInstance().addMessage(null, msg); 
       orderList.remove((OrderBean) event.getObject());
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
   
}