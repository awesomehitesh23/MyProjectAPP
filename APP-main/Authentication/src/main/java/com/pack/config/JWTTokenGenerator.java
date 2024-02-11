package com.pack.config;

import java.util.Map;

import com.pack.model.UserLogin;

public interface JWTTokenGenerator {

    Map<String, String> generateToken(UserLogin user);
}
