package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.WeatherDao;
import com.prowings.model.Weather;

@Service
 class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	WeatherDao dao;

	@Override
	public Weather createWeatherCity(Weather weather) {
		
		return dao.save(weather);
	}

	@Override
	public Weather getWeatherId(int id) {
		
		return dao.findById(id).get();
	}

	@Override
	public List<Weather> getAllWeatherId() {
		
		return dao.findAll();
	}

	@Override
	public void updateWeatherId(Weather weather) {
		Weather weatherDB=dao.findById(weather.getWeatherCityId()).orElseThrow();
		dao.save(weather);
		
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

	
	
	

}
