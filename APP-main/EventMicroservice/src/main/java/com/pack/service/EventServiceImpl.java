package com.pack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pack.model.EventList;

@Service
public class EventServiceImpl implements EventService {
	
	Logger logger=LoggerFactory.getLogger(EventServiceImpl.class);
	
	String API_URL="https://api.seatgeek.com/2/events?client_id=Mzk0MTc3MjF8MTcwNTEyNzg5NS4yODk5ODY&client_secret=26b1165c40a85df221e751741bdc6765a4cc40fd28cecd0b61999732a9aa9a5d";


	private final RestTemplate restTemplate;

	public EventServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public EventList getAllEvents() {
		
		//logger.info("Retrieved all events from 3rd party URL");
		return restTemplate.getForObject(API_URL, EventList.class);

	}
}
