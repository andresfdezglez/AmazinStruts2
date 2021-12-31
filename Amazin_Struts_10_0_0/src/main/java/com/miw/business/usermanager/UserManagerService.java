package com.miw.business.usermanager;

import java.util.List;

import com.miw.model.User;

public interface UserManagerService {

	public List<User> getUsers() throws Exception;

	public void insertUser(User u) throws Exception;

	User getUserByUserName(String username) throws Exception;

	public User getUserByUserNameAndPassword(String username, String password);
}
