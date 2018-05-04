package com.test.guest.repository;

import com.test.guest.model.GuestProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestProfileRepository extends CrudRepository<GuestProfile,Long> {
}
