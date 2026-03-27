package com.esra.realestate.entity;

import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property_search_requests")
@Getter
@Setter
public class PropertySearchRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_type", length = 20)
    private ListingType listingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", length = 30)
    private PropertyType propertyType;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "min_square_meters")
    private Integer minSquareMeters;

    @Column(name = "max_square_meters")
    private Integer maxSquareMeters;

    @Column(name = "min_price")
    private Double minPrice;

    @Column(name = "max_price")
    private Double maxPrice;

    @Column(name = "min_room_count")
    private Integer minRoomCount;

    @Column(name = "max_room_count")
    private Integer maxRoomCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "heating_type", length = 30)
    private HeatingType heatingType;

    @Column(name = "furnished")
    private Boolean furnished;
}