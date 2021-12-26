package com.miw.presentation.di;

import javax.servlet.http.HttpSession;

public interface HttpSessionAware {
	public void setHttpSession(HttpSession session );
}
