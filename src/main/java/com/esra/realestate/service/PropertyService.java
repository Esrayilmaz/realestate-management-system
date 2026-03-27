package com.esra.realestate.service;

import com.esra.realestate.dto.request.PropertyCreateRequest;
import com.esra.realestate.dto.request.PropertyUpdateRequest;
import com.esra.realestate.dto.response.PropertyResponse;

import java.util.List;

public interface PropertyService {

    PropertyResponse save(PropertyCreateRequest request);

    List<PropertyResponse> findAll();

    PropertyResponse findById(Long id);

    PropertyResponse update(Long id, PropertyUpdateRequest request);

    void delete(Long id);
}