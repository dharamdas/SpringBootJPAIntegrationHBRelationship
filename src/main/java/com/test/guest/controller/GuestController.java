package com.test.guest.controller;

import com.test.guest.model.City;
import com.test.guest.model.GuestProfile;
import com.test.guest.service.AddressService;
import com.test.guest.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guest")
@Slf4j
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public ResponseEntity<Object> createProfile(@RequestBody GuestProfile guestProfile) {
        log.info("Fetching all Cities");
        GuestProfile guestProfileResponse = guestService.createProfile(guestProfile);
        return new ResponseEntity<Object>(guestProfileResponse, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/profile/{guestId}",method = RequestMethod.GET)
    public ResponseEntity<Object> getProfileById(@PathVariable Long guestId) {
        log.info("Fetching all Cities");
        GuestProfile guestProfileResponse = guestService.getbyGuestId(guestId);
        return new ResponseEntity<Object>(guestProfileResponse, HttpStatus.FOUND);
    }


    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProfile(@RequestParam Long guestId) {
        log.info("Fetching all Cities");
        GuestProfile guestProfileResponse = guestService.getbyGuestId(guestId);
        return new ResponseEntity<Object>(guestProfileResponse, HttpStatus.FOUND);
    }


}
