package com.esra.realestate.mapper;

import com.esra.realestate.dto.request.AgencyCreateRequest;
import com.esra.realestate.dto.response.AgencyResponse;
import com.esra.realestate.entity.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyMapper {

    public Agency toEntity(AgencyCreateRequest request) {
        Agency agency = new Agency();
        agency.setBusinessName(request.getBusinessName());
        agency.setAuthorizedPerson(request.getAuthorizedPerson());
        agency.setAddress(request.getAddress());
        agency.setPhone(request.getPhone());
        agency.setFax(request.getFax());
        return agency;
    }

    public AgencyResponse toResponse(Agency agency) {
        AgencyResponse response = new AgencyResponse();
        response.setId(agency.getId());
        response.setBusinessName(agency.getBusinessName());
        response.setAuthorizedPerson(agency.getAuthorizedPerson());
        response.setAddress(agency.getAddress());
        response.setPhone(agency.getPhone());
        response.setFax(agency.getFax());
        return response;
    }
}