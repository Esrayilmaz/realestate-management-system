package com.esra.realestate.dto.request;

import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyType;
import com.esra.realestate.enums.CustomerType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertySearchRequestDto {

   // @NotNull(message = "Müşteri Boş Geçilemez")
    private Long customerId;

    private ListingType listingType;
    private PropertyType propertyType;
    private CustomerType customerType;
    private String city;
    private String district;
    private Integer minSquareMeters;
    private Integer maxSquareMeters;
    private Double minPrice;
    private Double maxPrice;
    private Integer minRoomCount;
    private Integer maxRoomCount;
    private HeatingType heatingType;
    private Boolean furnished;
}