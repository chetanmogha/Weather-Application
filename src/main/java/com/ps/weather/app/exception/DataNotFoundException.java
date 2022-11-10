package com.ps.weather.app.exception;


/**
*
* Exception class when the api is not working properly to fetch the information
*
* @author Chetan
* 
*
*/
public class DataNotFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}

	public DataNotFoundException(String message, Throwable e) {
		super(message,e);
	}
}
