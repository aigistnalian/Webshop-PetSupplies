/**
 * 
 */
package com.petstore.admin.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.petstore.util.Util;

/**
 * @author analian
 *
 */
@ManagedBean(name = "sidebar")
@SessionScoped
public class SideBarController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8969017736390777114L;

	public String sendToCategoryPage() {
		HttpSession session = Util.getSession();
		String user = (String) session.getAttribute("username");
		if (user != null) {
			return "/main/category";
		} else {
			   FacesContext.getCurrentInstance().addMessage(
	                      null,
	                      new FacesMessage(FacesMessage.SEVERITY_WARN,
	                      "Invalid Link!",
	                      "Please Login!"));
			return "landing";
		}
	}
	
	 public String logout() {
	        HttpSession session = Util.getSession();
	        session.invalidate();
	         return "/login?faces-redirect=true" ;
	     }

	public String sendToProductPage() {
		HttpSession session = Util.getSession();
		String user = (String) session.getAttribute("username");
		if (user != null) {
			return "/main/product";
		} else {
			return "landing";
		}
	}

}
