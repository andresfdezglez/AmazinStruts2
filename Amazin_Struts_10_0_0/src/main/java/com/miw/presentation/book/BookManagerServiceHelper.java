package com.miw.presentation.book;

import java.util.List;

import org.apache.logging.log4j.*;

import com.miw.infrastructure.Factories;
import com.miw.model.Book;

public class BookManagerServiceHelper {

	Logger logger = LogManager.getLogger(this.getClass());

	public List<Book> getBooks() throws Exception {
		logger.debug("Retrieving Books from Business Layer");
		return (Factories.services.getBookManagerService()).getBooks();
	}

	public Book getSpecialOffer() throws Exception {
		logger.debug("Retrieving Special Offer from Business Layer");
		return (Factories.services.getBookManagerService()).getSpecialOffer();
	}
	
}
