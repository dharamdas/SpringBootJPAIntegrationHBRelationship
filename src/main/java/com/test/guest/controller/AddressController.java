package com.test.guest.controller;

import com.test.guest.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

}
