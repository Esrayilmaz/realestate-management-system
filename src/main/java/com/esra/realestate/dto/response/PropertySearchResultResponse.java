package com.esra.realestate.dto.response;

import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertySearchResultResponse {

    private Long id;
    private String title;
    private ListingType listingType;
    private PropertyType propertyType;
    private String city;
    private String district;
    private Integer squareMeters;
    private Integer roomCount;
    private HeatingType heatingType;
    private Boolean furnished;
    private Double price;
    private String ownerFullName;
}