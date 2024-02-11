package com.pack.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {

		//logger.error("User not found");
		return new ResponseEntity<>("User not found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> handleUserIdAlreadyExistsException(UserAlreadyExistException exception) {
		
		//logger.error("User already exists");
		return new ResponseEntity<>("User already exists", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)

	protected ResponseEntity<Object> handleInvalidData(MethodArgumentNotValidException ex, WebRequest req) {
		Map<String, Object> resbody = new LinkedHashMap();

		resbody.put("timestamp", new Date());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(ferror -> ferror.getDefaultMessage())
				.toList();
				

		resbody.put("Errors ", errors);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resbody);

	}

}