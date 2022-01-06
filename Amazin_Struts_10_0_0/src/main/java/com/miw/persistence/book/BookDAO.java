package com.miw.persistence.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.logging.log4j.*;

import com.miw.model.Book;
import com.miw.persistence.Dba;

public class BookDAO implements BookDataService {

	protected Logger logger = LogManager.getLogger(getClass());

	public List<Book> getBooks() throws Exception {

		List<Book> resultList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			resultList = em.createQuery("Select a From Book a", Book.class).getResultList();

			logger.debug("Result list: " + resultList.toString());
			for (Book next : resultList) {
				logger.debug("next book: " + next);
			}

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return resultList;
	}

	public boolean insertBook(Book newBook) {

		Dba dba = new Dba();
		try {

			EntityManager em = dba.getActiveEm();

			em.createNativeQuery(
					"insert into Book(Title,Description,Author,Taxgroup,Baseprice,Stock) values (?,?,?,?,?,?)",
					Book.class).setParameter(1, newBook.getTitle()).setParameter(2, newBook.getDescription())
					.setParameter(3, newBook.getAuthor()).setParameter(4, newBook.getVat().getTaxGroup())
					.setParameter(5, newBook.getBasePrice()).setParameter(6, newBook.getStock()).executeUpdate();

			em.getTransaction().commit();
			logger.debug("Book inserted" + newBook);

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return true;
	}

	public Book getBookById(int id) {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			Book book = em.createQuery("SELECT a FROM Book a WHERE a.id = ?", Book.class).setParameter(1, id)
					.getSingleResult();
			return book;
		} catch (NoResultException e) {
			return null;
		} finally {
			dba.closeEm();
		}
	}

	public boolean update(Book book) {
		Dba dba = new Dba();
		try {

			EntityManager em = dba.getActiveEm();

			em.createNativeQuery("update Book set stock=? where id=?", Book.class).setParameter(1, book.getStock())
					.setParameter(2, book.getId()).executeUpdate();

			em.getTransaction().commit();
			logger.debug("Book updated" + book);

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return true;
	}
}