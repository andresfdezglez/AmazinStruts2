package com.miw.presentation.di;

import javax.servlet.http.HttpServletRequest;

public interface ServletRequestAware {
	public void setServletRequest(HttpServletRequest request );
}
