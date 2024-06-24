package com.prowings.service;

import java.util.List;

import com.prowings.model.Weather;

public interface WeatherService {

	Weather createWeatherCity(Weather weather);

	Weather getWeatherId(int id);

	List<Weather> getAllWeatherId();

	void updateWeatherId(Weather weather);

	void deleteById(int id);

	

	

}
