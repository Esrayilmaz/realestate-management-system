package com.esra.realestate.entity;

import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyStatus;
import com.esra.realestate.enums.PropertyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "properties")
@Getter
@Setter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_type", nullable = false, length = 20)
    private ListingType listingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", nullable = false, length = 30)
    private PropertyType propertyType;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "square_meters")
    private Integer squareMeters;

    @Column(name = "room_count")
    private Integer roomCount;

    @Column(name = "floor_number")
    private Integer floorNumber;

    @Column(name = "building_floors")
    private Integer buildingFloors;

    @Enumerated(EnumType.STRING)
    @Column(name = "heating_type", length = 30)
    private HeatingType heatingType;

    @Column(name = "furnished")
    private Boolean furnished;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private PropertyStatus status;

    @ManyToOne
    @JoinColumn(name = "owner_customer_id", nullable = false)
    private Customer owner;
}