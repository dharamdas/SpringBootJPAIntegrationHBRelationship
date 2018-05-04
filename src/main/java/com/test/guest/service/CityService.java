package com.test.guest.service;

import com.test.guest.model.City;

import java.util.List;

public interface CityService {
    public List<City> findAll();
    public City createCity(City city);
    default public City findCityById(Long id){
        return null;
    }
}
