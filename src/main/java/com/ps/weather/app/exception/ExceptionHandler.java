package com.ps.weather.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
*
* Exception handler to route the relevant exception 
*
* @author Chetan
* 
*
*/

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleException(DataNotFoundException ex) {
		ErrorResponse errorRespone = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(errorRespone, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleException(CityNotFoundException ex) {
		ErrorResponse errorRespone = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(errorRespone, HttpStatus.FORBIDDEN);
	}
	
}
