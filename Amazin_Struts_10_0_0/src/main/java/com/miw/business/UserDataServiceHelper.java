package com.miw.business;

import java.util.List;

import com.miw.infrastructure.Factories;
import com.miw.model.User;

public class UserDataServiceHelper {

	public List<User> getUsers() throws Exception {
		return (Factories.dataServices.getUserDataService()).getUsers();
	}
	
	public void insertUser(User u) throws Exception {
		(Factories.dataServices.getUserDataService()).insertUser(u);
	}
}
