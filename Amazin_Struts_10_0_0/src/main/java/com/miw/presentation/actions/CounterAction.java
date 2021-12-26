package com.miw.presentation.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;

import com.miw.model.Counter;
import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", location="login-success.jsp" )

public class CounterAction extends ActionSupport implements ApplicationAware {

	private static final long serialVersionUID = 3754807639524838051L;
	private Map<String, Object> application = null;
	
	@Override
	public String execute() throws Exception {
		Counter counter = (Counter) application.get("counter");
		if ( counter == null )
		{
			counter = new Counter();
		}
		counter.increment();
		application.put("counter", counter);
		return SUCCESS;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	
}
