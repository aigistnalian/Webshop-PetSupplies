package com.petstore.constants;
/**
 * 
 */

/**
 * @author analian
 *
 */
public class Constants {

	public static final String ADMIN = "admin";
	public static final String ANON = "anonymous";
	public static final String USER = "user";
	
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String EMAIL_ID = "email";
	
	public static final String INVALID_LOGIN_MESSAGE = "Invalid Login!";
	public static final String TRY_AGAIN_MESSAGE = "Please Try Again!";
	
	public static final String EMPTY = "";
	
	public static final String DELETE_PRODUCT_SQL_STRING = "delete from Product where id = ";
	
	public static final String DELETE_CATEGORY_SQL_STRING = "delete from ProductCategory where id = ";
	
	public static final String SELECT_PRODUCT_SQL_STRING = "select p from Product p";
	
	public static final String CATEGORY_PAGE_STRING = "/main/category";
	
	public static final String PRODUCT_PAGE_STRING = "/main/product";
	
	public static final String LANDING_PAGE_STRING = "landing";
	
	public static final String LOGIN_PAGE_STRING = "login";
	
	public static final String INVALID_LINK_MESSAGE = "Invalid Link!";
	
	public static final String PLEASE_LOGIN_MESSAGE =  "Please Login!";
	
	public static final String LOGIN_REDIRECT_STRING = "/login?faces-redirect=true" ;
	
}
