package com.test.guest.controller;

import com.test.guest.model.City;
import com.test.guest.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
@Slf4j
public class CityController {

    @Autowired
   private CityService cityService;


    @RequestMapping("/get")
    public ResponseEntity<Object> findCities() {
        log.info("Fetching all Cities");
        List<City> cities = (List<City>) cityService.findAll();

        return new ResponseEntity<Object>(cities,HttpStatus.FOUND);
    }


    @RequestMapping("/get/{id}")
    public ResponseEntity<Object> findCities(@PathVariable Long id) {
        log.info("Fetching all City {}",id);
        City city =  cityService.findCityById(id);

        return new ResponseEntity<Object>(city,HttpStatus.FOUND);
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<City> createCity(@RequestBody City city) {
        log.info("Creating new City with Name {}",city.getName());
        City cities=null;
        try {
            cities = cityService.createCity(city);
        }catch (Exception e)
        {
            log.error("Creating city failed with namne {}",city.getName(),e);
        }
        return new ResponseEntity<City>(city, HttpStatus.CREATED);
    }
}
