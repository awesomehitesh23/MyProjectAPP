package com.pack.exception;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.pack.response.ResponseHandler;

import jakarta.servlet.ServletException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
    @ExceptionHandler(WishListEventNotFoundException.class)
    public ResponseEntity<Object> handleWishListEventNotFoundException(WishListEventNotFoundException exception) {
        
    	//logger.error("Event not found in the wishlist");
    	return ResponseHandler.generateResponse("Event not found", HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage());
    }
    
    @ExceptionHandler(WishListEventAlreadyExistsException.class)
    public ResponseEntity<Object> handleEventAlreadyExistsException(WishListEventAlreadyExistsException exception) {
        
    	//logger.error("Event with given Id already exists for the user in the wishlist");
    	return ResponseHandler.generateResponse("Event with given Id already exists for the user", HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage());
    }
    
    @ExceptionHandler(ServletException.class)
    public ResponseEntity<Object> handleServletException(ServletException exception) {
        
    	//logger.error("Invalid siganature /Someone illegally modified token");
    	return ResponseHandler.generateResponse("Invalid siganature /Someone illegally modified token", HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)

  	protected ResponseEntity<Object> handleInvalidData(MethodArgumentNotValidException ex,WebRequest req)
  	{
  		Map<String ,Object> resbody= new LinkedHashMap();
  		
  		resbody.put("timestamp", new Date());
  		
  		List<String> errors=ex.getBindingResult().getFieldErrors().stream()
  				.map( ferror->ferror.getDefaultMessage()).toList();
  		
  		resbody.put("Errors " , errors);
  		
  		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resbody);
  				
  		
  	}

   
   
}