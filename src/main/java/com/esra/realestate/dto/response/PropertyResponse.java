package com.esra.realestate.dto.response;

import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyStatus;
import com.esra.realestate.enums.PropertyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyResponse {

    private Long id;
    private String title;
    private String description;
    private ListingType listingType;
    private PropertyType propertyType;
    private String city;
    private String district;
    private String address;
    private Integer squareMeters;
    private Integer roomCount;
    private Integer floorNumber;
    private Integer buildingFloors;
    private HeatingType heatingType;
    private Boolean furnished;
    private Double price;
    private PropertyStatus status;

    private Long ownerCustomerId;
    private String ownerFullName;
}