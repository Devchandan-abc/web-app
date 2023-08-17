package com.demo.imageUpload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FileNotFoundException extends RuntimeException {
	
	   public FileNotFoundException() {  }   
	   
	   public FileNotFoundException(String message, Throwable cause) { 
		   super(message, cause);    
		   }  
	   
	   public FileNotFoundException(String message) {       
		   super(message);   
		   } 
	   
		   public FileNotFoundException(Throwable cause) {         
			   super(cause); 
			   } 
}

