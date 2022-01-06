package com.miw.persistence.book;

import java.util.List;

import com.miw.model.Book;

public interface BookDataService {

	List<Book> getBooks() throws Exception;

	boolean insertBook(Book newBook);

	Book getBookById(int id);

	boolean update(Book book);

}