package com.esra.realestate.controller;

import com.esra.realestate.dto.request.PropertySearchRequestDto;
import com.esra.realestate.dto.response.PropertySearchResultResponse;
import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyType;
import com.esra.realestate.service.PropertySearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-search")
public class PropertySearchController {

    private final PropertySearchService propertySearchService;

    public PropertySearchController(PropertySearchService propertySearchService) {
        this.propertySearchService = propertySearchService;
    }

    @PostMapping("/search")
    public List<PropertySearchResultResponse> search(@RequestBody PropertySearchRequestDto request) {
        return propertySearchService.search(request);
    }

    @GetMapping("/sample")
    public List<PropertySearchResultResponse> sampleSearch() {
        PropertySearchRequestDto request = new PropertySearchRequestDto();
        request.setCustomerId(1L);
        request.setListingType(ListingType.RENT);
        request.setPropertyType(PropertyType.APARTMENT);
        request.setCity("Ankara");
        request.setMinSquareMeters(80);
        request.setMaxPrice(25000.0);
        request.setMinRoomCount(2);
        request.setHeatingType(HeatingType.NATURAL_GAS);
        request.setFurnished(false);

        return propertySearchService.search(request);
    }
}