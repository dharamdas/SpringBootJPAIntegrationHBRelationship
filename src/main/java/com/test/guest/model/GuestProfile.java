package com.test.guest.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guestprofile")
@EqualsAndHashCode
@Getter
@Setter
public class GuestProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="guestid")
    private Long guestId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date date =new Date();


    @OneToMany(mappedBy = "guestProfile")
    private Set<Address> addresses = new HashSet<Address>();
}
