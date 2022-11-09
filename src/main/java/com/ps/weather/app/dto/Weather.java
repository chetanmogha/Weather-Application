package com.ps.weather.app.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Weather {
	private String cod;
	private int message;
	private int cnt;
	private List<WeatherDataList> list=new ArrayList<>();
	

}


    
   