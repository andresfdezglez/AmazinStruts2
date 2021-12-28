package com.miw.business.usermanager;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miw.business.UserDataServiceHelper;
import com.miw.model.User;

public class UserManager implements UserManagerService {
	Logger logger = LogManager.getLogger(this.getClass());

	public List<User> getUsers() throws Exception {
		logger.debug("Asking for users");
		List<User> users = (new UserDataServiceHelper()).getUsers();

		return users;
	}

	public void insertUser(User u) throws Exception {
		// TODO Auto-generated method stub

	}

}
