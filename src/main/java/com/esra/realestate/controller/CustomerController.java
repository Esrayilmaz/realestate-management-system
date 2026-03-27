package com.esra.realestate.controller;

import com.esra.realestate.dto.request.CustomerCreateRequest;
import com.esra.realestate.dto.response.CustomerResponse;
import com.esra.realestate.enums.CustomerType;
import com.esra.realestate.service.CustomerService;
import com.esra.realestate.dto.request.CustomerUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable("id") Long id,
                                           @Valid @RequestBody CustomerUpdateRequest request) {
        return customerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return "Customer deleted successfully";
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/create-sample")
    public CustomerResponse createSampleCustomer() {
        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setFirstName("Esra");
        request.setLastName("Yılmaz");
        request.setHomePhone("03120000000");
        request.setMobilePhone("05550000000");
        request.setEmail("esra@example.com");
        request.setCustomerType(CustomerType.BUYER);
        request.setNotes("Örnek müşteri kaydı");

        return customerService.save(request);
    }

    @PostMapping
    public CustomerResponse createCustomer(@Valid @RequestBody CustomerCreateRequest request) {
        return customerService.save(request);
    }
}