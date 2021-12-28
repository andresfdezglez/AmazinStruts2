package com.miw.business;

import org.apache.logging.log4j.*;

import com.miw.business.bookmanager.BookManager;
import com.miw.business.bookmanager.BookManagerService;
import com.miw.business.usermanager.UserManager;
import com.miw.business.usermanager.UserManagerService;

public class SimpleServicesFactory implements ServicesFactory {

	Logger logger = LogManager.getLogger(this.getClass());

	public BookManagerService getBookManagerService() {
		logger.debug("Serving an instance of BookManagerService from " + this.getClass().getName());
		return new BookManager();
	}

	public UserManagerService getUserManagerService() {
		logger.debug("Serving an instance of UserManagerService from " + this.getClass().getName());
		return new UserManager();
	}

}
