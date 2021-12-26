package com.miw.business;

import org.apache.logging.log4j.*;

import com.miw.business.bookmanager.BookManager;
import com.miw.business.bookmanager.BookManagerService;

public class SimpleServicesFactory implements ServicesFactory {
	
	Logger logger = LogManager.getLogger(this.getClass());

	public BookManagerService getBookManagerService() {
		logger.debug("Serving an instance of BookManagerService from "+this.getClass().getName());
		return new BookManager();
	}

}
