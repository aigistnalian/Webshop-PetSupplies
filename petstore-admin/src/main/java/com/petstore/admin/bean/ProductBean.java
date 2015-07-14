/**
 * 
 */
package com.petstore.admin.bean;

import java.io.Serializable;

/**
 * @author analian
 *
 */
public class ProductBean implements Serializable 
{
	 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private String item;
    /**
     * 
     */
    private String desc;
    /**
     * 
     */
    private Double price;
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private int pcId;
	/**
	 * 
	 */
	private String sku;
 
    /**
     * @param item
     * @param desc
     * @param price
     */
    public ProductBean(String item, String desc, Double price) 
    {
        this.item = item;
        this.desc = desc;
        this.price = price;
    }    
 
    /**
     * @return
     */
    public String getItem() 
    {
        return item;
    }
 
    /**
     * @param item
     */
    public void setItem(String item) 
    {
        this.item = item;
    }
 
    /**
     * @return
     */
    public Double getPrice() 
    {
        return price;
    }
 
    /**
     * @param price
     */
    public void setPrice(Double price) 
    {
        this.price = price;
    }
 
	/**
	 * @return the desc
	 */
	public String getDesc() 
	{
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) 
	{
		this.desc = desc;
	}

	/**
	 * @return the id
	 */
	public int getId() 
	{
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}

	/**
	 * @return the pcId
	 */
	public int getPcId() 
	{
		return this.pcId;
	}

	/**
	 * @param pcId the pcId to set
	 */
	public void setPcId(int pcId) 
	{
		this.pcId = pcId;
	}

	/**
	 * @return the sku
	 */
	public String getSku() 
	{
		return this.sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) 
	{
		this.sku = sku;
	}    
}