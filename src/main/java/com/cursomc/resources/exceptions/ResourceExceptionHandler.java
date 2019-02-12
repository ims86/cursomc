package com.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursomc.services.exception.DataIntegrityExceptions;
import com.cursomc.services.exception.ObjecNotFoundExceptions;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjecNotFoundExceptions.class)
	public ResponseEntity<StandardError> objectNotFound(ObjecNotFoundExceptions e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(DataIntegrityExceptions.class)
	public ResponseEntity<StandardError> dataIntegity(DataIntegrityExceptions e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}

}
