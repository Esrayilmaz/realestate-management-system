package com.esra.realestate.service;

import com.esra.realestate.dto.request.AgencyCreateRequest;
import com.esra.realestate.dto.request.AgencyUpdateRequest;
import com.esra.realestate.dto.response.AgencyResponse;

public interface AgencyService {

    AgencyResponse save(AgencyCreateRequest request);

    AgencyResponse findById(Long id);

    AgencyResponse update(Long id, AgencyUpdateRequest request);
}