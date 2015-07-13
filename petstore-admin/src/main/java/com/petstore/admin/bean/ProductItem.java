package com.petstore.admin.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import com.petstore.model.bo.Product;
import com.petstore.model.bo.ProductCategory;
import com.petstore.service.CategoryService;
import com.petstore.service.ProductService;
	
@ManagedBean(name = "item")
@SessionScoped
public class ProductItem implements Serializable {

	   private static final long serialVersionUID = 1L;
	   private String item;
	   private String description;
	   private Double price;
	   private String category; 
	   
	   private Map<Integer,String> categories;
	   
	   @Inject
	   ProductService productService;
	   
	   @Inject
	   CategoryService categoryService;
	   
	   
	   @PostConstruct
	   public void init() {
		  refreshProductList();
		 
		  categories = new HashMap<Integer, String>();
		  List<ProductCategory> categoriesList = categoryService.findAllCategories();
		  for (ProductCategory productCategory : categoriesList) {
			  categories.put(productCategory.getId(),productCategory.getName());
		}
	   }

	public void refreshProductList() {
		List<Product> productsList = productService.fetchAllProductDetails();
		  System.out.println(productsList);
		  
		  productList.clear();
		  
		  for (Product product : productsList) {
			ProductBean pBean = new ProductBean(product.getName(), product.getDescription(), product.getPrice().doubleValue());
			pBean.setId(product.getId());
			pBean.setPcId(product.getProduct_category_id());
			pBean.setSku(product.getSku());
			productList.add(pBean);
		}
	}
	
	   /**
		 * @param event
		 */
		public void onEdit(RowEditEvent event) {  
		       FacesMessage msg = new FacesMessage("Item Edited",((ProductBean) event.getObject()).getItem());  
		       ProductBean pBean = (ProductBean) event.getObject();
				 Product product = new Product();
				 product.setName(pBean.getItem());
				 product.setDescription(pBean.getDesc());
				 product.setPrice(BigDecimal.valueOf(pBean.getPrice()));
				 product.setId(pBean.getId());
				 product.setSku(pBean.getSku());
				 product.setProduct_category_id(pBean.getPcId());
		       productService.updateProduct(product);
		       FacesContext.getCurrentInstance().addMessage(null, msg);  
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
		   if(productList==null){
			   refreshProductList();
		   }
	       return productList;
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
	public Map<Integer, String> getCategories() {
		return categories;
	}
	
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Map<Integer, String> categories) {
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