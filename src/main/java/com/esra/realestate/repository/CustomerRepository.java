package com.esra.realestate.repository;

import com.esra.realestate.entity.Customer;
import com.esra.realestate.enums.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}