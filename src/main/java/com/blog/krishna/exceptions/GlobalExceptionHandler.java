package com.blog.krishna.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.krishna.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundHandler(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		return new ResponseEntity<>(new ApiResponse(message,false),HttpStatus.NOT_FOUND);
	}

}
