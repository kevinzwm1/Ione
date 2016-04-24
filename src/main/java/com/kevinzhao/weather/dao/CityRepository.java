package com.kevinzhao.weather.dao;

import com.kevinzhao.weather.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}

