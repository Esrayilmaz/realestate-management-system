package com.esra.realestate.service;

import com.esra.realestate.dto.request.AgencyCreateRequest;
import com.esra.realestate.dto.response.AgencyResponse;
import com.esra.realestate.entity.Agency;
import com.esra.realestate.mapper.AgencyMapper;
import com.esra.realestate.repository.AgencyRepository;
import com.esra.realestate.dto.request.AgencyUpdateRequest;
import com.esra.realestate.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;
    private final AgencyMapper agencyMapper;

    public AgencyServiceImpl(AgencyRepository agencyRepository, AgencyMapper agencyMapper) {
        this.agencyRepository = agencyRepository;
        this.agencyMapper = agencyMapper;
    }

    @Override
    public AgencyResponse save(AgencyCreateRequest request) {
        Agency agency = agencyMapper.toEntity(request);
        Agency savedAgency = agencyRepository.save(agency);
        return agencyMapper.toResponse(savedAgency);
    }

    @Override
    public AgencyResponse findById(Long id) {
        return agencyRepository.findById(id)
                .map(agencyMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with id: " + id));
    }
    @Override
    public AgencyResponse update(Long id, AgencyUpdateRequest request) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with id: " + id));

        agency.setBusinessName(request.getBusinessName());
        agency.setAuthorizedPerson(request.getAuthorizedPerson());
        agency.setAddress(request.getAddress());
        agency.setPhone(request.getPhone());
        agency.setFax(request.getFax());

        Agency updatedAgency = agencyRepository.save(agency);
        return agencyMapper.toResponse(updatedAgency);
    }
}