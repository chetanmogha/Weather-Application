package com.ps.weather.app.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WeatherDataList {
	
	private String dt;
	private Main main;
	private List<WeatherDetails> weather=new ArrayList<>();
	private Cloud cloud;
	private Wind wind;
	private int visibility;
	private float pop;
	private String dt_txt;

}
