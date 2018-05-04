package com.test.guest.service;

import com.test.guest.model.City;
import com.test.guest.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) repository.findAll();

        return cities;
    }

    @Override
    public City createCity(City city) {
        return repository.save(city);
    }

    public City findCityById(Long id){
        return repository.findOne(id);
    }
}
