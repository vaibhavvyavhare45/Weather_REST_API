package com.prowings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionCongfig {
	@ExceptionHandler(WeatherNotFoundException.class)
	public ResponseEntity<ErrorResponse> getWeatherNotFoundException(WeatherNotFoundException ex){
		
		ErrorResponse res=new ErrorResponse("weather not found", ex.getMessage());
		
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
		
	}

}
