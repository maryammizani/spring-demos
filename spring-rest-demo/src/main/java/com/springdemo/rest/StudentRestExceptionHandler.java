package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

		// Add an Exception Handler to catch StudentNotFoundException exception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
			
			// Create a StudentErrorResponse
			StudentErrorResponse lError= new StudentErrorResponse();
			lError.setStatus(HttpStatus.NOT_FOUND.value());
			lError.setMessage(exc.getMessage());
			lError.setTimeStamp(System.currentTimeMillis());
			
			// Return a ResponseEntity
			return new ResponseEntity<>(lError, HttpStatus.NOT_FOUND);
		}
		
		// Add another Exception Handler ... to catch any exception
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			StudentErrorResponse lError= new StudentErrorResponse();
			lError.setStatus(HttpStatus.BAD_REQUEST.value());
			lError.setMessage(exc.getMessage());
			lError.setTimeStamp(System.currentTimeMillis());
			
			// Return a ResponseEntity
			return new ResponseEntity<>(lError, HttpStatus.BAD_REQUEST);
		}
}
