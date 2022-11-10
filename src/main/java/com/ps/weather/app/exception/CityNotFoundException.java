package com.ps.weather.app.exception;

/**
*
* Exception class when the city weather data is not found
*
* @author Chetan
* 
*
*/
public class CityNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CityNotFoundException(String message) {
		super(message);
	}
	
	public CityNotFoundException(String message, Throwable e) {
		super(message,e);
	}

	

}
