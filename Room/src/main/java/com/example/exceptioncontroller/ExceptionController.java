package com.example.exceptioncontroller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> notFound(EmptyResultDataAccessException ex) {
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(java.lang.NumberFormatException.class)
	public ResponseEntity<Object> nfe(java.lang.NumberFormatException e) {
		return new ResponseEntity<Object>("User ID not found with input Id",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> notFound(Exception ex) {
		System.out.println(ex.getLocalizedMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
