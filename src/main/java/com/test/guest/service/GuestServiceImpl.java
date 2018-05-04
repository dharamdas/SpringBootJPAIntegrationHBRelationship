package com.test.guest.service;

import com.test.guest.model.Address;
import com.test.guest.model.GuestProfile;
import com.test.guest.repository.AddressRepository;
import com.test.guest.repository.GuestProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private  GuestProfileRepository guestProfileRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public GuestProfile createProfile(GuestProfile guestProfile) {
        System.out.println("GuestId: "+guestProfile.getGuestId());
        GuestProfile guestProfile1 = guestProfileRepository.save(guestProfile);
        return guestProfile1;
    }

    @Override
    public List<GuestProfile> getAllProfile() {
        List<GuestProfile> list =new ArrayList<>();
         guestProfileRepository.findAll().forEach(e->list.add(e));
         return list;
    }

    @Override
    public GuestProfile getbyGuestId(Long guestId) {
        return guestProfileRepository.findOne(guestId);
    }
}
