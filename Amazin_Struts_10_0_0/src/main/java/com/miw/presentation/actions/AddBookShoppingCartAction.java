package com.miw.presentation.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.BookShoppingCart;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/WEB-INF/content/book-shopping-cart-form.jsp"),
		// For validation
		@Result(name = "no-book-selected", location = "/WEB-INF/content/book-shopping-cart-form.jsp"),
		@Result(name = "no-stock", location = "/WEB-INF/content/book-shopping-cart-form.jsp") })

public class AddBookShoppingCartAction extends ActionSupport implements RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -564573145494612792L;

	private List<String> listBooks;

	public List<String> getListBooks() {
		return listBooks;
	}

	public void setListBooks(List<String> listBooks) {
		this.listBooks = listBooks;
	}

	private Map<String, Object> session = null;

	private Map<String, Object> request = null;

	@Override
	public String execute() throws Exception {

		if (this.listBooks.size() == 0) {

			request.put("noBookSelected", "You must select at least one book");
			return "no-book-selected";
		}

		BookShoppingCart bookShoppingCart = (BookShoppingCart) session.get("shoppingCart");

		if (bookShoppingCart == null) {
			bookShoppingCart = new BookShoppingCart();

			session.put("shoppingCart", bookShoppingCart);
		}

		for (String key : this.listBooks) {

			if (key != null) {
				add(bookShoppingCart, key);
			}
		}

		request.put("bookAdded", "Shopping cart has been updated");

		return SUCCESS;
	}

	private void add(BookShoppingCart shoppingCart, String key) {
		Integer quantity = shoppingCart.getShoppingCartList().get(key);

		if (quantity == null) {
			shoppingCart.getShoppingCartList().put(key, 1);
		} else {
			shoppingCart.getShoppingCartList().put(key, ++quantity);
		}
	}

	public void setRequest(Map<String, Object> request) {

		this.request = request;

	}

	public void setSession(Map<String, Object> session) {

		this.session = session;

	}

}
