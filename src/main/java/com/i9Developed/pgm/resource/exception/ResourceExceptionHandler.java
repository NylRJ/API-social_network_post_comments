package com.i9Developed.pgm.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.i9Developed.pgm.services.xception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
				
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError bodyStandardError = new StandardError(System.currentTimeMillis(), status.value(), "Objeto Não Encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(bodyStandardError);
	}
}
