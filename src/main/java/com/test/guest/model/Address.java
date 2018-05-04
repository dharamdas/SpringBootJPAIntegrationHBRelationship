package com.test.guest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "address")
@Getter
@Setter
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressid")
    private Integer addressId;

    @Column(name = "pincode")
    private Integer pinCode;

    @Column(name = "landmark")
    private String landmark;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "guestid")
    private GuestProfile guestProfile;
}
