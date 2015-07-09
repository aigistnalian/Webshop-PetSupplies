/**
 * 
 */
package com.petstore.admin.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.petstore.service.LoginService;
import com.petstore.util.Util;

/**
 * @author analian
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class ManagedLoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7829457603314371883L;
    private String password;
    private String message, uname;
    
    @Inject 
    LoginService loginService;
    
    public String loginProject(){
    	  boolean result = loginService.validateUserLogin(uname, password);
          System.out.println(result);
          if (result) {
              // get Http Session and store username
              HttpSession session = Util.getSession();
              session.setAttribute("username", uname);
              return "landing";
          } else {
   
              FacesContext.getCurrentInstance().addMessage(
                      null,
                      new FacesMessage(FacesMessage.SEVERITY_WARN,
                      "Invalid Login!",
                      "Please Try Again!"));
   
              // invalidate session, and redirect to other pages
              
              //message = "Invalid Login. Please Try Again!";
              return "login";
          }
    }

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
