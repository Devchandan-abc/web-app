package com.demo.imageUpload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=FileNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleFileNotFoundException(FileNotFoundException exception) {    
		ErrorResponse errorResponse = new ErrorResponse();     
		errorResponse.setErrorMessage(exception.getMessage());   
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.toString());     
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); 
		}
}
