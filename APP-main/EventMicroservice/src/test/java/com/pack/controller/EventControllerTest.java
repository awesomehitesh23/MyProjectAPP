//package com.pack.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pack.model.EventList;
//import com.pack.service.EventService;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@ExtendWith(MockitoExtension.class)
////@MockitoSettings(strictness = Strictness.LENIENT)
//class EventControllerTest {
//	
//	 private MockMvc mockMvc;
//
//	@Mock
//	EventService service;
//
//	@InjectMocks
//	EventController eventController;
//
//	EventList list=new EventList();
//	
//	
//	@Test
//    void givenUserIdThenShouldReturnUser() throws Exception {
//		
//		assertNotNull(eventController.getAllEvents());
//		}
//
//  
//
//}