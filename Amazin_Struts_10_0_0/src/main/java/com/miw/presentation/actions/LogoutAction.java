package com.miw.presentation.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/index.jsp")

})
public class LogoutAction extends ActionSupport implements SessionAware {

	Logger logger = LogManager.getLogger(this.getClass());
	private static final long serialVersionUID = -3854762737466390371L;

	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {

		logger.debug("Logging out");
		session.put("loginInfo", null);
		return SUCCESS;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
