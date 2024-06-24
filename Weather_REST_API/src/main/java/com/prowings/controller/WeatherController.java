package com.prowings.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.exception.WeatherNotFoundException;
import com.prowings.model.Weather;
import com.prowings.service.WeatherService;

@RestController
@RequestMapping("/weather-api")
public class WeatherController {

	@Autowired
	WeatherService service;

	@PostMapping
	public Weather createWeatherCity(@RequestBody Weather weather) {
		return service.createWeatherCity(weather);

	}

	@GetMapping("/{id}")
	public Weather getWeatherById(@PathVariable("id") int id) {
		Weather weather = service.getWeatherId(id);

		if (weather!=null)
			return weather;
		else
			throw new WeatherNotFoundException("Weather not found");
	}

	@GetMapping
	public List<Weather> getAllWeatherId() {

		return service.getAllWeatherId();
	}

	@PutMapping
	public ResponseEntity<String> updateWeatherId(@RequestBody Weather weather) {
		try {
			service.updateWeatherId(weather);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
