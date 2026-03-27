package com.esra.realestate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agencies")
@Getter
@Setter
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name", nullable = false, length = 150)
    private String businessName;

    @Column(name = "authorized_person", nullable = false, length = 100)
    private String authorizedPerson;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "fax", length = 20)
    private String fax;
}