package com.ps.weather.app.dto;

import lombok.Data;

@Data
public class WeatherDetails {
	private float id;
	private String main;
	private String description;
	private String icon;

}
