
package com.miw.business.bookmanager;

import java.util.List;

import org.apache.logging.log4j.*;

import com.miw.business.BookDataServiceHelper;
import com.miw.business.VATDataServiceHelper;
import com.miw.model.Book;
import com.miw.model.VAT;

public class BookManager implements BookManagerService {
	Logger logger = LogManager.getLogger(this.getClass());

	public List<Book> getBooks() throws Exception {
		logger.debug("Asking for books");
		List<Book> books = (new BookDataServiceHelper()).getBooks();

		// We calculate the final price with the VAT value
		for (Book b : books) {
			b.setPrice(b.getBasePrice() * (1 + b.getVat().getValue()));
		}
		return books;
	}

	public Book getSpecialOffer() throws Exception {
		List<Book> books = getBooks();
		int number = (int) (Math.random() * books.size());
		logger.debug("Applying disccount to " + books.get(number).getTitle());
		books.get(number).setPrice((double) books.get(number).getPrice() * 0.85);
		return books.get(number);
	}

	public boolean insertBook(Book newBook) throws Exception {

		VAT vat = (new VATDataServiceHelper()).getVATByTaxGroup(newBook.getVat().getTaxGroup());

		if (vat.equals(null))
			return false;
		else {

			return (new BookDataServiceHelper()).insertBook(newBook);

		}

	}

	public Book getBookById(int id) {
		logger.debug("Asking for book by id");
		Book book = (new BookDataServiceHelper()).getBookById(id);
		book.setPrice(book.getBasePrice() * (1 + book.getVat().getValue()));
		return book;
	}

	public boolean update(Book book) {

		if (book.getStock() > 0) {
			book.setStock(book.getStock() - 1);
			return (new BookDataServiceHelper()).updateBook(book);

		} else {
			return false;
		}

	}
}
