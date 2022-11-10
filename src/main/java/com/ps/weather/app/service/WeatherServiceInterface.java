package com.ps.weather.app.service;

import java.util.List;

import com.ps.weather.app.dto.Weather;
import com.ps.weather.app.dto.WeatherResult;

public interface WeatherServiceInterface {

	public List<WeatherResult> getWeatherInformation(Weather result, String city);
}
