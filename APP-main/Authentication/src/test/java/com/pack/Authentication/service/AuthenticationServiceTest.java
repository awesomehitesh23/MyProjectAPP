//package com.pack.Authentication.service;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.pack.exception.UserNotFoundException;
//import com.pack.model.UserLogin;
//import com.pack.repository.AuthenticationRepository;
//import com.pack.service.AuthenticationServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//class AuthenticationServiceTest {
//
//	@Mock
//	private AuthenticationRepository repository;
//
//	@InjectMocks
//	private AuthenticationServiceImpl service;
//	
//	UserLogin user;
//
//	@BeforeEach
//	public void setUp() {
//		user = new UserLogin();
//		user.setPassword("ankita");
//		user.setUserId(1);
//
//	}
//
//	@AfterEach
//	public void tearDown() {
//		user = null;
//	}
//
//	@Test
//    void givenUserDetailsThenShouldReturnRespectiveUser() throws UserNotFoundException {
//		
//        when(repository.findByUserIdAndPassword(any(),any())).thenReturn(Optional.of(new UserLogin()));
//        assertNotNull( service.getUser(user));
//    }
//
//	@Test
//	void givenNonExistentUserDetailsThenShouldThrowUserNotFoundException() {
//		
//		 when(repository.findByUserIdAndPassword(any(),any())).thenReturn(Optional.empty());
//		 assertThrows(UserNotFoundException.class, ()->{
//			 service.getUser(user);
//		 });
//		verify(repository,times(1)).findByUserIdAndPassword(any(),any());
//	}
//
//	@Test
//    void givenUserToSaveThenShouldNotReturnSavedUser() {
//		when(repository.save(any())).thenReturn(new UserLogin());
//		assertNotNull(service.saveUser(any()));
//		
//		  verify(repository,times(1)).save(any());
//    }
//}
