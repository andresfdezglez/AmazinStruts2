package com.miw.model;

public class Counter {

	private Integer count = 0;
	
	public void increment()
	{
		count++;
	}
	
	@Override
	public String toString() {
		return count.toString();
	}
}
