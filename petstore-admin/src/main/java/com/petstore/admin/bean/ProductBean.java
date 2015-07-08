/**
 * 
 */
package com.petstore.admin.bean;

import java.io.Serializable;

/**
 * @author analian
 *
 */
public class ProductBean implements Serializable {
	 
    private static final long serialVersionUID = 1L;
    private String item;
    private String desc;
    private Double price;
 
    public ProductBean(String item, String desc, Double price) {
        this.item = item;
        this.desc = desc;
        this.price = price;
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
 
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}    
}