package com.miw.business;

import com.miw.business.bookmanager.BookManagerService;
import com.miw.business.usermanager.UserManagerService;

public interface ServicesFactory {
	public BookManagerService getBookManagerService();

	public UserManagerService getUserManagerService();
	
}
