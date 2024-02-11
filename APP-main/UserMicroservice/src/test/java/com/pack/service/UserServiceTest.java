package com.pack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.pack.exception.UserIdAlreadyExistsException;
import com.pack.exception.UserNotFoundException;
import com.pack.model.User;
import com.pack.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;


	@Test
    void givenGetAllUsersThenShouldReturnListOfAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(new User(), new User()));
 
        List<User> userList = userService.getAllUsers();
 
        assertEquals(2, userList.size());
    }

	@Test
    void givenUserIdThenShouldReturnRespectiveUser() throws UserNotFoundException {
		
        when(userRepository.findById(1)).thenReturn(Optional.of(new User()));
        User user = userService.getUserById(1);
        assertNotNull(user);
    }
	
	@Test
	void givenNonExistentUserIdThenShouldThrowUserNotFoundException() {
		
		when(userRepository.findById(any())).thenReturn(Optional.empty());
		assertThrows(UserNotFoundException.class,()->userService.getUserById(3));
		verify(userRepository,times(1)).findById(any());
	}
	
	@Test
    void givenUserToSaveThenShouldNotReturnSavedUser() {
		 when(userRepository.existsById(any())).thenReturn(true);
	     assertThrows(UserIdAlreadyExistsException.class, () -> userService.createUser(new User()));
	     verify(userRepository,times(1)).existsById(any());
    }

	@Test
	void testUpdateUser() throws UserNotFoundException {

		User existingUser = new User(1, "Peter", "peter@example.com", "123456789");
		
		when(userRepository.findById(1)).thenReturn(Optional.of(existingUser));
		when(userRepository.save(existingUser)).thenReturn(existingUser);
		
		User newUser = userService.updateUser(existingUser);
	
		verify(userRepository, times(1)).save(existingUser);
		verify(userRepository, atMost(2)).findById(existingUser.getUserId());

	}
	
	@Test
	void givenUpdateNonExistentUserThenShouldThrowUserNotFoundException() {
		

		when(userRepository.findById(any())).thenReturn(Optional.empty());
		assertThrows(UserNotFoundException.class,()->userService.updateUser(new User()));
		verify(userRepository,times(1)).findById(any());
		
	}

}
