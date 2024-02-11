package com.pack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.UserNotFoundException;
import com.pack.model.UserLogin;
import com.pack.repository.AuthenticationRepository;




@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	//Logger logger=LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	private AuthenticationRepository authenticationRepository;

	@Autowired
	public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
		super();
		this.authenticationRepository = authenticationRepository;
	}

	
	
	@Override
	public UserLogin saveUser(UserLogin user) {

		//logger.info("Used saved successfully");
		return authenticationRepository.save(user);

	}

	@Override
	public UserLogin getUser(UserLogin user) throws UserNotFoundException {

		Optional<UserLogin> user1 = authenticationRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		if (user1.isPresent()) {
			//logger.info("Used found in the DB successfully");
			return user1.get();

		}
		//logger.error("User not found");
		throw new UserNotFoundException("User not found");

	}

}
