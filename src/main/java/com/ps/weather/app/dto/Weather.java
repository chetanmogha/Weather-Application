package com.ps.weather.app.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
	
	private String cod;
	private int message;
	private int cnt;
	private List<WeatherDataList> list=new ArrayList<>();
	

}


    
   