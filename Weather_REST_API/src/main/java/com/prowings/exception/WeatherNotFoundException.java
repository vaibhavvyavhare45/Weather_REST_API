package com.prowings.exception;

public class WeatherNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeatherNotFoundException(String msg) {
		super(msg);
	}

}
