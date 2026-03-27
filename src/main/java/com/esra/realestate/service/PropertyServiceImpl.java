package com.esra.realestate.service;

import com.esra.realestate.dto.request.PropertyCreateRequest;
import com.esra.realestate.dto.response.PropertyResponse;
import com.esra.realestate.entity.Customer;
import com.esra.realestate.entity.Property;
import com.esra.realestate.enums.CustomerType;
import com.esra.realestate.mapper.PropertyMapper;
import com.esra.realestate.repository.CustomerRepository;
import com.esra.realestate.repository.PropertyRepository;
import com.esra.realestate.dto.request.PropertyUpdateRequest;
import com.esra.realestate.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final CustomerRepository customerRepository;
    private final PropertyMapper propertyMapper;

    public PropertyServiceImpl(PropertyRepository propertyRepository,
                               CustomerRepository customerRepository,
                               PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.customerRepository = customerRepository;
        this.propertyMapper = propertyMapper;
    }

    @Override
    public PropertyResponse save(PropertyCreateRequest request) {
        Customer owner = customerRepository.findById(request.getOwnerCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + request.getOwnerCustomerId()));

        if (owner.getCustomerType() == CustomerType.BUYER) {
            throw new IllegalStateException("Alıcı tipindeki müşteri için emlak kaydı oluşturulamaz.");
        }

        Property property = propertyMapper.toEntity(request, owner);
        Property savedProperty = propertyRepository.save(property);

        return propertyMapper.toResponse(savedProperty);
    }

    @Override
    public List<PropertyResponse> findAll() {
        return propertyRepository.findAll()
                .stream()
                .map(propertyMapper::toResponse)
                .toList();
    }

    @Override
    public PropertyResponse findById(Long id) {
        return propertyRepository.findById(id)
                .map(propertyMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));
    }
    @Override
    public PropertyResponse update(Long id, PropertyUpdateRequest request) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));

        Customer owner = customerRepository.findById(request.getOwnerCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + request.getOwnerCustomerId()));

        if (owner.getCustomerType() == CustomerType.BUYER) {
            throw new IllegalStateException("Alıcı tipindeki müşteri için emlak kaydı oluşturulamaz.");
        }

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

        Property updatedProperty = propertyRepository.save(property);
        return propertyMapper.toResponse(updatedProperty);
    }

    @Override
    public void delete(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));

        propertyRepository.delete(property);
    }
}