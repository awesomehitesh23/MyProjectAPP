package com.pack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pack.exception.UserIdAlreadyExistsException;
import com.pack.exception.UserNotFoundException;
import com.pack.model.AppConstants;
import com.pack.model.User;
import com.pack.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	Logger log=LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;
	
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private Gson gson;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	
	}

	// Get All Users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Get User By Id
	public User getUserById(int userId) throws UserNotFoundException {

		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			//log.info("User found with given Id");
			return user.get();
		} else {
			//log.error("User not found");
			throw new UserNotFoundException("User not found with id : " + userId);
		}

	}

	// Create a User
	public User createUser(User user) throws UserIdAlreadyExistsException {

		// Check if a blog with the same ID already exists
		if (userRepository.existsById(user.getUserId())) {
			//log.error("User with ID " + user.getUserId() + " already exists.");
			throw new UserIdAlreadyExistsException("User with ID " + user.getUserId() + " already exists.");
		}
		kafkaTemplate.send(AppConstants.TOPIC,gson.toJson(user));
		return userRepository.save(user);

	}

	// Update User
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> user1 = userRepository.findById(user.getUserId());

		if (user1.isPresent()) {
			User updatedUser = user1.get();
			updatedUser.setPassword(user.getPassword());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPhoneNumber(user.getPhoneNumber());
			userRepository.save(updatedUser);
			return updatedUser;

		} else {
			
			//log.error("User not found with id : " + user.getUserId());
			throw new UserNotFoundException("User not found with id : " + user.getUserId());

		}
	}
}