package com.esra.realestate.service;

import com.esra.realestate.dto.request.CustomerCreateRequest;
import com.esra.realestate.dto.request.CustomerUpdateRequest;
import com.esra.realestate.dto.response.CustomerResponse;
import com.esra.realestate.entity.Customer;
import com.esra.realestate.enums.CustomerType;
import com.esra.realestate.exception.ResourceNotFoundException;
import com.esra.realestate.mapper.CustomerMapper;
import com.esra.realestate.repository.CustomerRepository;
import com.esra.realestate.repository.PropertyRepository;
import com.esra.realestate.repository.PropertySearchRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final PropertyRepository propertyRepository;
    private final PropertySearchRequestRepository propertySearchRequestRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper,
                               PropertyRepository propertyRepository,
                               PropertySearchRequestRepository propertySearchRequestRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.propertyRepository = propertyRepository;
        this.propertySearchRequestRepository = propertySearchRequestRepository;
    }
    @Override
    public List<CustomerResponse> findPropertyOwners() {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getCustomerType() == CustomerType.SELLER
                        || customer.getCustomerType() == CustomerType.OWNER)
                .map(customerMapper::toResponse)
                .toList();
    }
    @Override
    public CustomerResponse save(CustomerCreateRequest request) {
        Customer customer = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public CustomerResponse update(Long id, CustomerUpdateRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setHomePhone(request.getHomePhone());
        customer.setMobilePhone(request.getMobilePhone());
        customer.setEmail(request.getEmail());
        customer.setCustomerType(request.getCustomerType());
        customer.setNotes(request.getNotes());

        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(updatedCustomer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        boolean hasProperties = propertyRepository.existsByOwnerId(id);
        if (hasProperties) {
            throw new IllegalStateException("Bu müşteriye bağlı emlak kayıtları bulunduğu için silinemez.");
        }

        boolean hasSearchRequests = propertySearchRequestRepository.existsByCustomerId(id);
        if (hasSearchRequests) {
            throw new IllegalStateException("Bu müşteriye bağlı emlak arama talepleri bulunduğu için silinemez.");
        }

        customerRepository.delete(customer);
    }
}