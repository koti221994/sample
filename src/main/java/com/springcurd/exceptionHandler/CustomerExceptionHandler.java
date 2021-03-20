package com.springcurd.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	
	// exception handling based on id
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFound notFound){
		CustomerErrorResponse errorResponse=new CustomerErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(notFound.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);	
	}	
	// handle any exception getting throug catch block
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exception){
		CustomerErrorResponse errorResponse=new CustomerErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	

}
