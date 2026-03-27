package com.esra.realestate.repository;

import com.esra.realestate.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
}