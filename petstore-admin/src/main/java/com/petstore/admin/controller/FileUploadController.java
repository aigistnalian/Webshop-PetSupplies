package com.petstore.admin.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@RequestScoped
public class FileUploadController implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param event
	 */
	public void uploadFile(FileUploadEvent event) 
	{
        byte[] file = event.getFile().getContents();

        System.out.println("MADE IT INTO FILE UPLOAD !!! ");
   }
}
