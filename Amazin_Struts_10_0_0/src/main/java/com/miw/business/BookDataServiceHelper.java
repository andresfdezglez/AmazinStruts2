package com.miw.business;

import java.util.List;

import com.miw.infrastructure.Factories;
import com.miw.model.Book;

public class BookDataServiceHelper {

	public List<Book> getBooks() throws Exception {
		return (Factories.dataServices.getBookDataService()).getBooks();
	}

	public boolean insertBook(Book newBook) {
		return (Factories.dataServices.getBookDataService()).insertBook(newBook);
	}

	public Book getBookById(int id) {
		return (Factories.dataServices.getBookDataService()).getBookById(id);
	}

	public boolean updateBook(Book book) {
		return (Factories.dataServices.getBookDataService()).update(book);
	}
}
