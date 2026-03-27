package com.esra.realestate.mapper;

import com.esra.realestate.dto.request.PropertyCreateRequest;
import com.esra.realestate.dto.response.PropertyResponse;
import com.esra.realestate.entity.Customer;
import com.esra.realestate.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    public Property toEntity(PropertyCreateRequest request, Customer owner) {
        Property property = new Property();
        property.setTitle(request.getTitle());
        property.setDescription(request.getDescription());
        property.setListingType(request.getListingType());
        property.setPropertyType(request.getPropertyType());
        property.setCity(request.getCity());
        property.setDistrict(request.getDistrict());
        property.setAddress(request.getAddress());
        property.setSquareMeters(request.getSquareMeters());
        property.setRoomCount(request.getRoomCount());
        property.setFloorNumber(request.getFloorNumber());
        property.setBuildingFloors(request.getBuildingFloors());
        property.setHeatingType(request.getHeatingType());
        property.setFurnished(request.getFurnished());
        property.setPrice(request.getPrice());
        property.setStatus(request.getStatus());
        property.setOwner(owner);
        return property;
    }

    public PropertyResponse toResponse(Property property) {
        PropertyResponse response = new PropertyResponse();
        response.setId(property.getId());
        response.setTitle(property.getTitle());
        response.setDescription(property.getDescription());
        response.setListingType(property.getListingType());
        response.setPropertyType(property.getPropertyType());
        response.setCity(property.getCity());
        response.setDistrict(property.getDistrict());
        response.setAddress(property.getAddress());
        response.setSquareMeters(property.getSquareMeters());
        response.setRoomCount(property.getRoomCount());
        response.setFloorNumber(property.getFloorNumber());
        response.setBuildingFloors(property.getBuildingFloors());
        response.setHeatingType(property.getHeatingType());
        response.setFurnished(property.getFurnished());
        response.setPrice(property.getPrice());
        response.setStatus(property.getStatus());

        if (property.getOwner() != null) {
            response.setOwnerCustomerId(property.getOwner().getId());
            response.setOwnerFullName(
                    property.getOwner().getFirstName() + " " + property.getOwner().getLastName()
            );
        }

        return response;
    }
}