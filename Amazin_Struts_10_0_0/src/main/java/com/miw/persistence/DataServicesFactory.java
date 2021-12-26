package com.miw.persistence;

import com.miw.persistence.book.BookDataService;
import com.miw.persistence.vat.VATDataService;

public interface DataServicesFactory {
	public BookDataService getBookDataService();
	public VATDataService getVATDataService();
}
