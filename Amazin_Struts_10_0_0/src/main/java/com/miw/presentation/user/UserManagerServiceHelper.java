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

	public void insertUser(User u) throws Exception {
		logger.debug("Retrieving Special Offer from Business Layer");
		(Factories.services.getUserManagerService()).insertUser(u);
	}

}
