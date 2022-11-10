package com.ps.weather.app.dto;

import lombok.Data;

@Data
public class WeatherResult {
	
	private String city;
	private Double high_temperature;
	private Double low_temperature;
	private String message;
	private String date;

}
