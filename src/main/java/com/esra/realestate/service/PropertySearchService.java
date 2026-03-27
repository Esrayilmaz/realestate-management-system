package com.esra.realestate.service;

import com.esra.realestate.dto.request.PropertySearchRequestDto;
import com.esra.realestate.dto.response.PropertySearchResultResponse;

import java.util.List;

public interface PropertySearchService {

    List<PropertySearchResultResponse> search(PropertySearchRequestDto request);
}