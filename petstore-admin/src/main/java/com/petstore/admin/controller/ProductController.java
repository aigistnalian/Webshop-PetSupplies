package com.petstore.admin.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;
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
@ManagedBean(name = "productController")
@RequestScoped
public class ProductController implements Serializable 
{
	/**
	 * 
	 */
	static final Logger log = Logger.getLogger(ProductController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 6612718331444190838L;

	/**
	 * 
	 */
	@Inject
	ProductService productService;

	/**
	 * 
	 */
	@ManagedProperty(value = "#{item}")
	private ProductItem item;

	/**
	 * @return
	 */
	public String addAction() 
	{
		log.info("Inside Product Controller --> Add Action");
		ProductBean productItem = new ProductBean(item.getItem(),
				item.getDescription(), item.getPrice());

		Product product = new Product();
		product.setProduct_category_id(Integer.valueOf(item.getCategory()));
		product.setDescription(item.getDescription());
		product.setName(item.getItem());
		product.setPrice(BigDecimal.valueOf(item.getPrice()));

		try 
		{ // For Fun --> Randomly generated Stock keeping unit value
			product.setSku(new String(SecureRandom.getInstance("SHA1PRNG").generateSeed(6)));
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}

		productService.addNewProduct(product);
		item.getProductList().add(productItem);
		log.info("Added new product");
		item.setItem(Constants.EMPTY);
		item.setPrice(0.0);
		item.setDescription(Constants.EMPTY);
		return null;
	}

	/**
	 * @param event
	 */
	public void onEdit(RowEditEvent editEvent) 
	{
		log.debug("Edit event fired for Product -->" + editEvent);
		FacesMessage msg = new FacesMessage("Item Edited", "FS");
		Product product = mapBeanToBo(editEvent);
		productService.updateProduct(product);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @param event
	 */
	public void onCancel(RowEditEvent cancelEvent) 
	{
		log.info("Delete event fired of Product ");
		FacesMessage msg = new FacesMessage("Item Removed");
		Product product = mapBeanToBo(cancelEvent);
		productService.removeSelectedProduct(product);

		item.refreshProductList();

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @param event
	 * @return
	 */
	private Product mapBeanToBo(RowEditEvent event) 
	{
		DataTable dataTable = (DataTable) event.getSource();
		log.debug("Datatable source --->" + dataTable);
		ProductBean pBean = (ProductBean) dataTable.getRowData();
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
	public ProductItem getItem() 
	{
		return this.item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(ProductItem item) 
	{
		this.item = item;
	}
}
