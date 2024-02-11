package com.pack.service;

import com.pack.exception.UserNotFoundException;
import com.pack.model.UserLogin;

public interface AuthenticationService {

    UserLogin saveUser(UserLogin user);

    UserLogin getUser(UserLogin user) throws UserNotFoundException;
}
