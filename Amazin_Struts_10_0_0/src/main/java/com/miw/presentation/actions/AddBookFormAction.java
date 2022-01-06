package com.miw.presentation.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class AddBookFormAction extends ActionSupport {

	private static final long serialVersionUID = -4752542581534740735L;
	Logger logger = LogManager.getLogger(this.getClass());

	public String execute() {
		logger.debug("Displaying book form");

		return SUCCESS;
	}

}
