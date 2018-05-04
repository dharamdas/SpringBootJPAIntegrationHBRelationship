package com.test.guest.service;

import com.test.guest.model.GuestProfile;

import java.util.List;

public interface GuestService {

    public GuestProfile createProfile(GuestProfile guestProfile);
    public List<GuestProfile> getAllProfile();
    public GuestProfile getbyGuestId(Long guestId);
}
