package com.miw.presentation.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

public class BookShoppingCartFormAction extends ActionSupport implements RequestAware, ApplicationAware {

	private static final long serialVersionUID = -514040179179406744L;

	Logger logger = LogManager.getLogger(this.getClass());
	Map<String, Object> request = null;
	Map<String, Object> application = null;

	public String execute() {
		logger.debug("Executing BookShoppingCartFormAction");
		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		try {

			application.put("books", helper.getBooks());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;

	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

}
