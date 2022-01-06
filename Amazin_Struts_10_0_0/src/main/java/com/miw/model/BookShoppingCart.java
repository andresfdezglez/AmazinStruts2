package com.miw.model;

import java.util.HashMap;

public class BookShoppingCart {

	private HashMap<String, Integer> shoppingCartList;

	public BookShoppingCart() {
		this.shoppingCartList = new HashMap<String, Integer>();
	}

	public HashMap<String, Integer> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(HashMap<String, Integer> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}

}
