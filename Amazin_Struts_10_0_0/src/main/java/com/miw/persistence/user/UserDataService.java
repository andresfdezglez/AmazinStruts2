package com.miw.persistence.user;

import java.util.List;

import com.miw.model.User;

public interface UserDataService {

	List<User> getUsers() throws Exception;

	void insertUser(User u) throws Exception;

	User getUserByUserName(String username);

	User getUserByUserNameAndPassword(String username, String password);
}
