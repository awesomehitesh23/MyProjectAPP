package com.pack.aspectJ;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pack.model.User;
import com.pack.response.ResponseHandler;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class UserApectJ {

	@AfterReturning(value = "execution(*  com.pack.controller.UserController.createUser(..))", returning = "obj")
	public void afterCreateUserReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {
		
		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		User user = (User) map.get("responseObj");
		//log.info("User with User Id " + user.getUserId() + " updated successfully:");

		//log.info("User with Email Id "+user.getEmail()+" added successfully:");
	}

	@AfterThrowing(value="execution(*  com.pack.controller.UserController.createUser(..))",throwing="e")
	public void afterCreateUserThrowingException(JoinPoint joinPoint,Exception e)
	{
		//log.error("Exception raised while adding user to DB: "+e.getMessage());
	}

	@AfterReturning(value = "execution(*  com.pack.controller.UserController.updateUser(..))", returning = "obj")
	public void afterUpdateUserReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		User user = (User) map.get("responseObj");
		//log.info("User with User Id " + user.getUserId() + " updated successfully:");

	}

	@AfterThrowing(value = "execution(*  com.pack.controller.UserController.updateUser(..))", throwing = "e")
	public void afterUpdateUserThrowingException(JoinPoint joinPoint, Exception e) {
		//log.error("Exception raised while updating user: " + e.getMessage());
	}
	
	@AfterReturning(value = "execution(*  com.pack.controller.UserController.getUserById(..))", returning = "obj")
	public void afterGetUserByIdReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		User user = (User) map.get("responseObj");
		//log.info("Retrieved User with User Id " + user.getUserId());

	}

	@AfterThrowing(value = "execution(*  com.pack.controller.UserController.getUserById(..))", throwing = "e")
	public void afterGetUserByIdThrowingException(JoinPoint joinPoint, Exception e) {
		//log.error("Exception raised while retrieving user: " + e.getMessage());
	}
	
	@AfterReturning(value = "execution(*  com.pack.controller.UserController.getUserById(..))", returning = "obj")
	public void afterGetAllUsersReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {

		//log.info("Retrieved all the users");

	}

}
