package com.pack.Authentication.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.config.JWTTokenGeneratorImpl;
import com.pack.controller.AuthenticationController;
import com.pack.model.UserLogin;
import com.pack.service.AuthenticationServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AuthenticationControllerTest {

	private MockMvc mockMvc;

	@Mock
	private JWTTokenGeneratorImpl jwtTokenGenerator;

	@Mock
	private AuthenticationServiceImpl service;

	@InjectMocks
	private AuthenticationController controller;

	private UserLogin user;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		user = new UserLogin(1, "ankita");

	}

	@AfterEach
	public void tearDown() {
		user = null;
	}

	@Test
	void testLoginUser() throws Exception {
		// Arrange
		
		Map<String, String> jwtTokenMap = new HashMap<>();

		jwtTokenMap.put("token", "token");
		jwtTokenMap.put("message", "message");
		
		
		UserLogin userDetails=new UserLogin(1, "ankita");
		when(service.getUser(user)).thenReturn(user);
		when(jwtTokenGenerator.generateToken(userDetails)).thenReturn(jwtTokenMap);

		// Act & Assert
		mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
	}

   
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
