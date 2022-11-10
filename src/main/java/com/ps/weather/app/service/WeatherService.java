package com.ps.weather.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ps.weather.app.dto.Weather;
import com.ps.weather.app.dto.WeatherDataList;
import com.ps.weather.app.dto.WeatherResult;
import com.ps.weather.app.utilities.Conversion;

@Service
public class WeatherService implements WeatherServiceInterface  {

	public List<WeatherResult> getWeatherInformation(Weather result, String city) {
		List<WeatherResult> weatherJsonResponse = new ArrayList<>();

		List<WeatherDataList> weatherData = result.getList();

		List<WeatherDataList> resultList = new ArrayList<>(3);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime firstDate = LocalDateTime.parse(weatherData.get(0).getDt_txt(), formatter);
		int firstDay = firstDate.getDayOfMonth();
		
		resultList.add(weatherData.get(0));

		for (int i = 0; i < weatherData.size(); i++) {
			LocalDateTime date = LocalDateTime.parse(weatherData.get(i).getDt_txt(), formatter);
			int d = date.getDayOfMonth();

			if (resultList.size() == 3) {
				break;
			}
			if (firstDay < d) {
				resultList.add(weatherData.get(i+4));
				firstDay = d;
			}
		}


		for (WeatherDataList data : resultList) {

			WeatherResult weatherInformation = new WeatherResult();

			weatherInformation.setHigh_temperature(Conversion.kelvinToCelsius(data.getMain().getTemp_max()));
			weatherInformation.setLow_temperature(Conversion.kelvinToCelsius(data.getMain().getTemp_min()));

			weatherInformation.setDate(data.getDt_txt());

			Double temperature = Conversion.kelvinToCelsius(data.getMain().getTemp());
			weatherInformation.setCity(city);

			if (temperature > 40.0) {
				weatherInformation.setMessage("Use sunscreen lotion");
				
			} 
			else if (data.getWeather().get(0).getMain().equalsIgnoreCase("Rain")) {
				weatherInformation.setMessage("Carry Umbrella");
				
			} 
			else {
				weatherInformation.setMessage(data.getWeather().get(0).getMain());
			}

			weatherJsonResponse.add(weatherInformation);
		}

		
		return weatherJsonResponse;
	}

}
