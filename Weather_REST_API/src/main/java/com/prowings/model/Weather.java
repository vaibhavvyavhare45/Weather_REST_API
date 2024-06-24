package com.prowings.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Weather {
	@Id
	int weatherCityId;
	String weatherCityName;
	String weatherCityDayStatus;
	String weatherCityTemprature;
}
