package com.pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.EventList;
import com.pack.service.EventService;


@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {
	
	Logger logger=LoggerFactory.getLogger(EventController.class);
	
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }
    
    @GetMapping("/viewAll")
    public ResponseEntity<EventList> getAllEvents()
    {
    	//logger.info("Retrieved all events from 3rd party URL successfully");
    	return new ResponseEntity<>(service.getAllEvents(),HttpStatus.OK);
    }
}
