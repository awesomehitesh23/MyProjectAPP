package com.pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.exception.UserIdAlreadyExistsException;
import com.pack.exception.UserNotFoundException;
import com.pack.model.User;
import com.pack.response.ResponseHandler;
import com.pack.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	Logger logger=LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/viewAll")
	public ResponseEntity<Object> getAllUsers() {

		List<User> list = userService.getAllUsers();
		//logger.info("Successfully retrieved data!");
		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, list);

	}

	@GetMapping("/viewUser/{userId}")
	public ResponseEntity<Object> getUserById(@PathVariable int userId) throws UserNotFoundException {

		//logger.info("Successfully retrieved data for given User Id!");
		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK,
				userService.getUserById(userId));

	}

	@PostMapping("/addUser")
	public ResponseEntity<Object> createUser(@RequestBody User user) throws UserIdAlreadyExistsException {

		//logger.info("User created successfully");
		return ResponseHandler.generateResponse("User created successfully", HttpStatus.CREATED,
				userService.createUser(user));
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody User user) throws UserNotFoundException {

		//logger.info("User updated successfully");
		return ResponseHandler.generateResponse("User updated successfully", HttpStatus.OK,
				userService.updateUser(user));
	}
	
	
}