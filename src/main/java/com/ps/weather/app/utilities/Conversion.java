package com.ps.weather.app.utilities;

import java.text.DecimalFormat;

public class Conversion {
	
	public static double kelvinToCelsius(double temperature) {
		 DecimalFormat df = new DecimalFormat("0.00");
		
		 return Double.parseDouble(df.format(temperature - 273.15F));
		
		
		
	}

}
