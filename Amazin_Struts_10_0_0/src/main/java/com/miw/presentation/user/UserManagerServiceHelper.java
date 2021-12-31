package com.miw.presentation.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserManagerServiceHelper {

	Logger logger = LogManager.getLogger(this.getClass());

	public List<User> getUsers() throws Exception {
		logger.debug("Retrieving Users from Business Layer");
		return (Factories.services.getUserManagerService()).getUsers();
	}

	public boolean insertUser(User u) throws Exception {
		logger.debug("Inserting User");

		if (getUserByUserName(u.getUser().toLowerCase()) != null)
			return false;
		else {
			(Factories.services.getUserManagerService()).insertUser(u);
			return true;
		}

	}

	public User getUserByUserName(String username) throws Exception {

		logger.debug("Getting user by username");

		User user = (Factories.services.getUserManagerService()).getUserByUserName(username);

		return user;

	}

	public User getUserByUserNameAndPassword(String username, String password) throws Exception {

		logger.debug("Getting user by username");

		User user = (Factories.services.getUserManagerService()).getUserByUserNameAndPassword(username,password);

		return user;

	}

}
