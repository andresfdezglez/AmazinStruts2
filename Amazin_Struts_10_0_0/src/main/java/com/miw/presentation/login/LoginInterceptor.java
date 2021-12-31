package com.miw.presentation.login;

import org.apache.logging.log4j.*;
import org.apache.struts2.StrutsStatics;

import com.miw.model.LoginInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

	private static final long serialVersionUID = -4077390198609734426L;
	Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public void init() {
		logger.debug("Interceptor login initialized");
		super.init();
	}

	@Override
	public void destroy() {
		logger.debug("Interceptor login destroyed");
		super.destroy();
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		logger.debug("Interceptor login fired");
		
		ActionContext ctx = invocation.getInvocationContext();

		LoginInfo loginInfo = (LoginInfo) ctx.getSession().get("loginInfo");
		String uri = ctx.getName().toLowerCase();
		
		// If the user is not logger we redirect to login
		if (loginInfo == null && !uri.contains("index")){
			logger.debug("Redirecting to Login");
			return "login-error";
		}
		
		// Otherwise, we let them pass through
		logger.debug("User is logged, we let them in: "+loginInfo + " redirected to "+invocation.invoke());
		return invocation.invoke();
	}

}
