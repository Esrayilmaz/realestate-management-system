package com.esra.realestate.mapper;

import com.esra.realestate.dto.request.CustomerCreateRequest;
import com.esra.realestate.dto.response.CustomerResponse;
import com.esra.realestate.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setHomePhone(request.getHomePhone());
        customer.setMobilePhone(request.getMobilePhone());
        customer.setEmail(request.getEmail());
        customer.setCustomerType(request.getCustomerType());
        customer.setNotes(request.getNotes());
        return customer;
    }

    public CustomerResponse toResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setHomePhone(customer.getHomePhone());
        response.setMobilePhone(customer.getMobilePhone());
        response.setEmail(customer.getEmail());
        response.setCustomerType(customer.getCustomerType());
        response.setNotes(customer.getNotes());
        return response;
    }
}