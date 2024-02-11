package com.pack.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pack.model.EventList;


import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j
public class EventAspectJ {
	@AfterReturning(value = "execution(*  com.pack.controller.EventController.getAllEvents(..))", returning = "obj")
	public void aftergetAllEventsReturningData(JoinPoint joinPoint, ResponseEntity<EventList> obj) {
		//Log.info("Retrieved all events from 3rd party URL successfully with Status code :" + obj.getStatusCode());
	}
}
