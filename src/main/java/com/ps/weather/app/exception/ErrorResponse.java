package com.ps.weather.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
* Response Message that has to be sent when any exception occurs
*
* @author Chetan
* 
*
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private String error_message;

}
