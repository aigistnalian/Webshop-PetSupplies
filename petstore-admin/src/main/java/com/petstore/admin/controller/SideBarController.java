/**
 * 
 */
package com.petstore.admin.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.petstore.util.Util;

/**
 * @author analian
 *
 */
@ManagedBean(name = "sidebar")
@RequestScoped
public class SideBarController {
	private UIComponent hidden;

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
			return "login";
		}
	}

	public String sendToProductPage() {
		HttpSession session = Util.getSession();
		String user = (String) session.getAttribute("username");
		if (user != null) {
			return "/main/category";
		} else {
			return "login";
		}
	}

	public void setHidden(UIComponent hidden) {
		this.hidden = hidden;
	}

	public UIComponent getHidden() {
		return hidden;
	}
}
