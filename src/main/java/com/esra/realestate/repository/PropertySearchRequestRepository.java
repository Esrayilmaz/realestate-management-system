package com.esra.realestate.repository;

import com.esra.realestate.entity.PropertySearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertySearchRequestRepository extends JpaRepository<PropertySearchRequest, Long> {

    boolean existsByCustomerId(Long customerId);
}