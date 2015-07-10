/**
 * 
 */
package com.petstore.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author analian
 *
 */
@Entity
@Table(name="LINE_ITEM")
public class LineItem {
	
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="ORDER_ID")
	private int order_id;
	@Column(name="PRODUCT_ID")
	private int product_id;
	@Column(name="AMOUNT")
	private int amount;
	@Column(name="NO_OF_PRODUCTS")
	private int no_of_products;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the order_id
	 */
	public int getOrder_id() {
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the no_of_products
	 */
	public int getNo_of_products() {
		return no_of_products;
	}

	/**
	 * @param no_of_products the no_of_products to set
	 */
	public void setNo_of_products(int no_of_products) {
		this.no_of_products = no_of_products;
	}
	
	

}
