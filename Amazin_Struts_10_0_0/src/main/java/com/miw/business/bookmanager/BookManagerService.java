package com.miw.business.bookmanager;

import java.util.List;

import com.miw.model.Book;

public interface BookManagerService {
	public List<Book> getBooks() throws Exception;
	public Book getSpecialOffer() throws Exception;

}