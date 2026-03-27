package com.esra.realestate.service;

import com.esra.realestate.dto.request.PropertySearchRequestDto;
import com.esra.realestate.dto.response.PropertySearchResultResponse;
import com.esra.realestate.entity.Customer;
import com.esra.realestate.entity.PropertySearchRequest;
import com.esra.realestate.exception.ResourceNotFoundException;
import com.esra.realestate.repository.CustomerRepository;
import com.esra.realestate.repository.PropertyRepository;
import com.esra.realestate.repository.PropertySearchRequestRepository;
import com.esra.realestate.specification.PropertySpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertySearchServiceImpl implements PropertySearchService {

    private final PropertyRepository propertyRepository;
    private final PropertySearchRequestRepository propertySearchRequestRepository;
    private final CustomerRepository customerRepository;

    public PropertySearchServiceImpl(PropertyRepository propertyRepository,
                                     PropertySearchRequestRepository propertySearchRequestRepository,
                                     CustomerRepository customerRepository) {
        this.propertyRepository = propertyRepository;
        this.propertySearchRequestRepository = propertySearchRequestRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<PropertySearchResultResponse> search(PropertySearchRequestDto request) {

        if (request.getCustomerId() != null) {
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + request.getCustomerId()));

            PropertySearchRequest searchRequest = new PropertySearchRequest();
            searchRequest.setCustomer(customer);
            searchRequest.setListingType(request.getListingType());
            searchRequest.setPropertyType(request.getPropertyType());
            searchRequest.setCity(request.getCity());
            searchRequest.setDistrict(request.getDistrict());
            searchRequest.setMinSquareMeters(request.getMinSquareMeters());
            searchRequest.setMaxSquareMeters(request.getMaxSquareMeters());
            searchRequest.setMinPrice(request.getMinPrice());
            searchRequest.setMaxPrice(request.getMaxPrice());
            searchRequest.setMinRoomCount(request.getMinRoomCount());
            searchRequest.setMaxRoomCount(request.getMaxRoomCount());
            searchRequest.setHeatingType(request.getHeatingType());
            searchRequest.setFurnished(request.getFurnished());

            propertySearchRequestRepository.save(searchRequest);
        }

        return propertyRepository.findAll(PropertySpecification.filterBy(request))
                .stream()
                .map(property -> {
                    PropertySearchResultResponse response = new PropertySearchResultResponse();
                    response.setId(property.getId());
                    response.setTitle(property.getTitle());
                    response.setListingType(property.getListingType());
                    response.setPropertyType(property.getPropertyType());
                    response.setCity(property.getCity());
                    response.setDistrict(property.getDistrict());
                    response.setSquareMeters(property.getSquareMeters());
                    response.setRoomCount(property.getRoomCount());
                    response.setHeatingType(property.getHeatingType());
                    response.setFurnished(property.getFurnished());
                    response.setPrice(property.getPrice());

                    if (property.getOwner() != null) {
                        response.setOwnerFullName(
                                property.getOwner().getFirstName() + " " + property.getOwner().getLastName()
                        );
                    }

                    return response;
                })
                .toList();
    }
}