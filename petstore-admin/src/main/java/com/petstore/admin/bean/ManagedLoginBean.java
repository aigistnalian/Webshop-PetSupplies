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

import com.petstore.constants.Constants;
import com.petstore.service.LoginService;
import com.petstore.util.Util;

/**
 * @author analian
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class ManagedLoginBean implements Serializable 
{
    /**
     * 
     */
    @Inject 
    LoginService loginService;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7829457603314371883L;
    /**
     * 
     */
    private String password;
    /**
     * 
     */
    private String message, uname;
    

    /**
     * @return
     */
    public String loginProject()
    {
    	  boolean result = loginService.validateAdminUserLogin(uname, password);
          System.out.println(result);
          if (result) 
          {
              // get Http Session and store username
              HttpSession session = Util.getSession();
              session.setAttribute(Constants.USERNAME, uname);
              return Constants.LANDING_PAGE_STRING;
          } 
          else 
          {
              FacesContext.getCurrentInstance().addMessage(
                      null,
                      new FacesMessage(FacesMessage.SEVERITY_WARN,
                      Constants.INVALID_LOGIN_MESSAGE,
                      Constants.TRY_AGAIN_MESSAGE));
   
              // invalidate session, and redirect to other pages
              return Constants.LOGIN_PAGE_STRING;
          }
    }

	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return this.password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}

	/**
	 * @return the message
	 */
	public String getMessage() 
	{
		return this.message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) 
	{
		this.message = message;
	}

	/**
	 * @return the uname
	 */
	public String getUname() 
	{
		return this.uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) 
	{
		this.uname = uname;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}
}
