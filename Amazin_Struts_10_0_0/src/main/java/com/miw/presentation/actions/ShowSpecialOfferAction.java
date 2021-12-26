package com.miw.presentation.actions;

import java.util.Map;

import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value ="miw.Amazin")

public class ShowSpecialOfferAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 4674623943937761755L;
	Logger logger = LogManager.getLogger(this.getClass());


	Map<String,Object> request = null;
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing "+this.getClass().getName());
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {
			request.put("book", helper.getSpecialOffer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}	
}
