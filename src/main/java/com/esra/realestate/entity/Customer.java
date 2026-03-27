package com.esra.realestate.entity;

import com.esra.realestate.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "home_phone", length = 20)
    private String homePhone;

    @Column(name = "mobile_phone", length = 20)
    private String mobilePhone;

    @Column(name = "email", length = 150)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type", nullable = false, length = 30)
    private CustomerType customerType;

    @Column(name = "notes", length = 500)
    private String notes;
}