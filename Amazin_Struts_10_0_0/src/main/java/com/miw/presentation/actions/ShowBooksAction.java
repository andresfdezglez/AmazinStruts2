package com.miw.presentation.actions;

import java.util.Map;

import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value ="miw.Amazin")

public class ShowBooksAction extends ActionSupport implements RequestAware  {
	
	private static final long serialVersionUID = -4752542581534740735L;
	Logger logger = LogManager.getLogger(this.getClass());
	Map<String,Object> request = null;

	public String execute() {
		logger.debug("Executing ShowBooksCommand");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			request.put("books", helper.getBooks());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;	
	}

	
}
