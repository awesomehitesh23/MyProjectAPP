package com.pack.service;

import java.util.List;

import com.pack.exception.UserIdAlreadyExistsException;
import com.pack.exception.UserNotFoundException;
import com.pack.model.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User getUserById(int userId) throws UserNotFoundException;
	
	public User createUser(User user) throws UserIdAlreadyExistsException;
	
	public User updateUser(User user) throws UserNotFoundException;
}
