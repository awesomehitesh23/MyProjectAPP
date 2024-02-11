package com.pack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.google.gson.Gson;
import com.pack.model.AppConstants;
import com.pack.model.UserLogin;
import com.pack.service.AuthenticationServiceImpl;

@Configuration
public class KafkaConfig {


	@Autowired
	Gson gson;
	
	@Autowired
	AuthenticationServiceImpl service;

	@KafkaListener(topics = AppConstants.TOPIC, groupId = AppConstants.GROUP_ID)
	public void register(String user) {

		UserLogin login = gson.fromJson(user, UserLogin.class);
		service.saveUser(login);
	}
}
