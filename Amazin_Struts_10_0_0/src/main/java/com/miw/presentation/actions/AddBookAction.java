package com.miw.presentation.actions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.Book;
import com.miw.model.VAT;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({ @Result(name = "success", location = "/WEB-INF/content/add-book-form.jsp"),
		@Result(name = "add-book-error", location = "/WEB-INF/content/add-book-form.jsp"),
		@Result(name = "input", location = "/WEB-INF/content/add-book-form.jsp")

})

@Validations(requiredStrings = {
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newBook.title", message = "You must enter a value for title"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newBook.author", message = "You must enter a value for author"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newBook.description", message = "You must enter a value description") }, requiredFields = {
				@RequiredFieldValidator(fieldName = "newBook.basePrice", message = "You must enter a value for basePrice"),
				@RequiredFieldValidator(fieldName = "vat.taxGroup", message = "You must enter a value for taxGroup of VAT") })

public class AddBookAction extends ActionSupport implements RequestAware, ApplicationAware {

	Logger logger = LogManager.getLogger(this.getClass());
	private static final long serialVersionUID = -3854762737466390371L;
	private Book newBook = null;
	private VAT vat = null;

	private Map<String, Object> request;
	private Map<String, Object> application = null;

	public Book getNewBook() {
		return newBook;
	}

	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}

	public VAT getVat() {
		return vat;
	}

	public void setVat(VAT vat) {
		this.vat = vat;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;

	}

	@Override
	public void validate() {
		logger.debug("Invoking validate!");

		super.validate();
	}

	@Override
	public String execute() throws Exception {

		BookManagerServiceHelper helper = new BookManagerServiceHelper();
		newBook.setVat(vat);
		newBook.setStock(1);
		System.out.println(newBook);
		logger.debug("Book created: " + newBook);

		boolean bookCreated = helper.insertBook(newBook);

		if (bookCreated) {

			@SuppressWarnings("unchecked")
			List<Book> listBooks = (List<Book>) application.get("books");
			if (listBooks != null) {
				listBooks = helper.getBooks();
				application.replace("books", listBooks);
				System.out.print(listBooks);
			}
			request.put("bookInserted", "New book has been inserted");
			return SUCCESS;
		}

		else {
			request.put("bookNotInserted", "New book has been inserted");
			return "add-book-error";
		}

	}

}
