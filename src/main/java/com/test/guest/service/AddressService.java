package com.test.guest.service;

import com.test.guest.model.Address;

public interface AddressService {

    public Address createAddress(Address address);
    public Address getAddressById(Long id);
}
