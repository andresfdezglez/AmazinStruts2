package com.miw.persistence;

import org.apache.logging.log4j.*;

import com.miw.persistence.book.BookDAO;
import com.miw.persistence.book.BookDataService;
import com.miw.persistence.user.UserDAO;
import com.miw.persistence.user.UserDataService;
import com.miw.persistence.vat.VATDAO;
import com.miw.persistence.vat.VATDataService;

public class SimpleDataServicesFactory implements DataServicesFactory {

	Logger logger = LogManager.getLogger(this.getClass());

	public BookDataService getBookDataService() {
		logger.debug("Serving an instance of BookDataService from " + this.getClass().getName());
		return new BookDAO();
	}

	public VATDataService getVATDataService() {
		logger.debug("Serving an instance of VATDataService from " + this.getClass().getName());
		return new VATDAO();
	}

	public UserDataService getUserDataService() {
		logger.debug("Serving an instance of UserDataService from " + this.getClass().getName());
		return new UserDAO();
	}
}
