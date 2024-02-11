package com.pack.aspectJ;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pack.model.UserLogin;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class AuthenticationAspectJ {

	@AfterReturning(value = "execution(*  com.pack.controller.AuthenticationController.loginUser(..))", returning = "obj")
	public void afterLoginUserReturningData(JoinPoint joinPoint, ResponseEntity<Object> obj) {
		
		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
		HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
		UserLogin user = (UserLogin) map.get("responseObj");
		//log.info("User with Email "+ user.getEmail()+" logged in and token generated successfully");
	}

	@AfterThrowing(value="execution(*  com.pack.controller.AuthenticationController.loginUser(..))",throwing="e")
	public void afterLoginUserThrowingException(JoinPoint joinPoint,Exception e)
	{
		//log.error("Exception raised while creating token: "+e.getMessage());
	}

}
