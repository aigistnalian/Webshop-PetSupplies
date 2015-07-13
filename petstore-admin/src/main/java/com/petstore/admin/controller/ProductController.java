package com.petstore.admin.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.RowEditEvent;

import com.petstore.admin.bean.ProductBean;
import com.petstore.admin.bean.ProductItem;
import com.petstore.constants.Constants;
import com.petstore.model.bo.Product;
import com.petstore.service.ProductService;

/**
 * @author analian
 *
 */
@ManagedBean(name="productController")
@SessionScoped
public class ProductController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6612718331444190838L;

	@Inject
	ProductService productService;
	
	@ManagedProperty(value="#{item}")
	private ProductItem item;
	
	
	/**
	 * @return
	 */
	public String addAction() {
	       ProductBean productItem = new ProductBean(item.getItem(), item.getDescription(), item.getPrice());
	     
	       Product product = new Product();
	       product.setProduct_category_id(Integer.valueOf(item.getCategory()));
	       product.setDescription(item.getDescription());
	       product.setName(item.getItem());
	       product.setPrice(BigDecimal.valueOf(item.getPrice()));
	      
	       try { // For Fun --> Randomly generated Stock keeping unit value
			product.setSku(new String(SecureRandom.getInstance("SHA1PRNG").generateSeed(6)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	     
	       productService.addNewProduct(product);
	       item.getProductList().add(productItem);
	       item.setItem(Constants.EMPTY);
	       item.setPrice(0.0);
	       item.setDescription(Constants.EMPTY);
	       return null;
	   }
	  
	  
	
	/**
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {  
	       FacesMessage msg = new FacesMessage("Item Removed");   
	       
	       Product product = mapBeanToBo(event);
	       
	       productService.removeSelectedProduct(product);
	       
	       item.refreshProductList();
	       
	       FacesContext.getCurrentInstance().addMessage(null, msg); 
	   }

	/**
	 * @param event
	 * @return
	 */
	private Product mapBeanToBo(RowEditEvent event) {
			
		   ProductBean pBean = (ProductBean) event.getObject();
			 Product product = new Product();
			 product.setName(pBean.getItem());
			 product.setDescription(pBean.getDesc());
			 product.setPrice(BigDecimal.valueOf(pBean.getPrice()));
			 product.setId(pBean.getId());
			 product.setSku(pBean.getSku());
			 product.setProduct_category_id(pBean.getPcId());
			 
			return product;
		}
		


	/**
	 * @return the item
	 */
	public ProductItem getItem() {
		return item;
	}


	/**
	 * @param item the item to set
	 */
	public void setItem(ProductItem item) {
		this.item = item;
	}
}
