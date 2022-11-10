package com.ps.weather.app.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ps.weather.app.dto.Weather;
import com.ps.weather.app.dto.WeatherResult;
import com.ps.weather.app.exception.CityNotFoundException;
import com.ps.weather.app.exception.DataNotFoundException;
import com.ps.weather.app.service.WeatherService;


/**
*
* Controller class to fetch the information from third party api
*
* @author Chetan
* 
*
*/

@RestController
@RequestMapping("/api/v1")
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/data")
	 public ResponseEntity<List<WeatherResult>> getCityWeatherData(@RequestParam String city) throws DataNotFoundException, CityNotFoundException {
		Weather result;
		if(city==null || city.isBlank()) {
			throw new CityNotFoundException("Please enter city name");
		}
		String uri = "https://api.openweathermap.org/data/2.5/forecast?q="+city+",us&mode=xm|&appid=d2929e9483efc82c82c32ee7e02d563e";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("API is running fine");
       
        try {
        	 result = restTemplate.getForObject(uri, Weather.class);
        }
        catch(HttpClientErrorException e) {
        	throw new DataNotFoundException(city+" data is not found! Please enter a valid city name",e);
        }
        List<WeatherResult> finalResult=weatherService.getWeatherInformation(result,city);
      
        
        return new ResponseEntity<>(finalResult, HttpStatus.OK);
        
    }
	

}
