package com.esra.realestate.service;

import com.esra.realestate.dto.request.CustomerCreateRequest;
import com.esra.realestate.dto.request.CustomerUpdateRequest;
import com.esra.realestate.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse save(CustomerCreateRequest request);

    List<CustomerResponse> findAll();

    List<CustomerResponse> findPropertyOwners();

    CustomerResponse findById(Long id);

    CustomerResponse update(Long id, CustomerUpdateRequest request);

    void delete(Long id);
}