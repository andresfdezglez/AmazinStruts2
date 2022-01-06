package com.miw.presentation.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.Book;
import com.miw.model.BookShoppingCart;
import com.miw.presentation.book.BookManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/WEB-INF/content/show-book-shopping-cart.jsp"),
		// For validation
		@Result(name = "no-stock", location = "/WEB-INF/content/show-book-shopping-cart.jsp"),
		@Result(name = "empty", location = "/WEB-INF/content/show-book-shopping-cart.jsp") })
public class BuyBookAction extends ActionSupport implements RequestAware, SessionAware {

	private static final long serialVersionUID = -1886762131586986321L;
	Map<String, Object> request = null;
	Map<String, Object> session = null;

	@Override
	public String execute() throws Exception {

		BookManagerServiceHelper helper = new BookManagerServiceHelper();

		BookShoppingCart shoppingCart = (BookShoppingCart) session.get("shoppingCart");
		if (shoppingCart != null) {
			for (String key : shoppingCart.getShoppingCartList().keySet()) {
				Book book = helper.getBookById(Integer.parseInt(key));

				if (!helper.updateBook(book)) {
					request.put("stockError", "No stock");
					return "no-stock";
				}

			}
		} else {
			request.put("empty", "Shopping Cart is empty");
			return "empty";
		}

		request.put("done", "Purchase made!");
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
