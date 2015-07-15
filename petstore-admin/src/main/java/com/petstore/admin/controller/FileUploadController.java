package com.petstore.admin.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import org.primefaces.event.FileUploadEvent;

import com.petstore.admin.bean.ProductItem;

public class FileUploadController implements Serializable
{
	@ManagedProperty(value="#{item}")
	ProductItem productItem;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String item;
	/**
	 * @param event
	 */
	public void uploadFile(FileUploadEvent event) 
	{
        byte[] file = event.getFile().getContents();
        System.out.println(file);
        System.out.println(getItem());
        System.out.println("MADE IT INTO FILE UPLOAD !!! ");
   }
	
	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}
	
	public ProductItem getProductItem() {
		return productItem;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

}
