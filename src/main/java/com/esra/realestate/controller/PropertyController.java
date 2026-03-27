package com.esra.realestate.controller;

import com.esra.realestate.dto.request.PropertyCreateRequest;
import com.esra.realestate.dto.request.PropertyUpdateRequest;
import com.esra.realestate.dto.response.PropertyResponse;
import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyStatus;
import com.esra.realestate.enums.PropertyType;
import com.esra.realestate.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyResponse> getAllProperties() {
        return propertyService.findAll();
    }

    @GetMapping("/{id}")
    public PropertyResponse getPropertyById(@PathVariable("id") Long id) {
        return propertyService.findById(id);
    }

    @GetMapping("/create-sample")
    public PropertyResponse createSampleProperty() {
        PropertyCreateRequest request = new PropertyCreateRequest();
        request.setTitle("Kiralık 2+1 Daire");
        request.setDescription("Merkezi konumda, temiz ve kullanışlı daire");
        request.setListingType(ListingType.RENT);
        request.setPropertyType(PropertyType.APARTMENT);
        request.setCity("Ankara");
        request.setDistrict("Çankaya");
        request.setAddress("Kızılay Mahallesi");
        request.setSquareMeters(95);
        request.setRoomCount(2);
        request.setFloorNumber(3);
        request.setBuildingFloors(7);
        request.setHeatingType(HeatingType.NATURAL_GAS);
        request.setFurnished(false);
        request.setPrice(18500.0);
        request.setStatus(PropertyStatus.ACTIVE);
        request.setOwnerCustomerId(1L);

        return propertyService.save(request);
    }

    @PostMapping
    public PropertyResponse createProperty(@Valid @RequestBody PropertyCreateRequest request) {
        return propertyService.save(request);
    }

    @PutMapping("/{id}")
    public PropertyResponse updateProperty(@PathVariable("id") Long id,
                                           @Valid @RequestBody PropertyUpdateRequest request) {
        return propertyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable("id") Long id) {
        propertyService.delete(id);
        return "Property deleted successfully";
    }
}