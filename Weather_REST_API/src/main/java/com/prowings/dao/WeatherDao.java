package com.prowings.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prowings.model.Weather;

@Repository
public interface WeatherDao extends JpaRepository<Weather, Integer> {

}
