package com.miw.presentation.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.miw.model.Book;
import com.miw.model.BookShoppingCart;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/WEB-INF/content/show-shopping-cart.jsp") })
public class ShowBookShoppingCartAction extends ActionSupport implements SessionAware, RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8601714422272740489L;

	Logger logger = LogManager.getLogger(this.getClass());
	private Map<String, Object> session = null;
	Map<Book, Double> listBook = new HashMap<Book, Double>();
	Map<String, Object> request = null;

	@Override
	public String execute() {
		logger.debug("The screen of the view of the sopping cart is displayed");
		listBook = new HashMap<Book, Double>();
		BookShoppingCart shoppingCart = (BookShoppingCart) session.get("shoppingCart");
		if (shoppingCart != null) {
			BookManagerServiceHelper helper = new BookManagerServiceHelper();
			double price = 0;
			for (String key : shoppingCart.getShoppingCartList().keySet()) {
				Book book = helper.getBookById(Integer.parseInt(key));
				double numero = shoppingCart.getShoppingCartList().get(key);
				price += book.getPrice() * numero;
				price = Math.round(price * Math.pow(10, 2)) / Math.pow(10, 2);
				listBook.put(book, numero);
			}
			request.put("shoppingCart", listBook);
			request.put("price", price);
		}
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
