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
		logger.debug("Inserting user");

		(new UserDataServiceHelper()).insertUser(u);

	}

	public User getUserByUserName(String username) throws Exception {
		logger.debug("Finding user by username");
		return (new UserDataServiceHelper()).getUserByUserName(username);
	}

	public User getUserByUserNameAndPassword(String username, String password) {
		logger.debug("Finding user by username and password");
		return (new UserDataServiceHelper()).getUserByUserNameAndPassword(username,password);
	}

}
