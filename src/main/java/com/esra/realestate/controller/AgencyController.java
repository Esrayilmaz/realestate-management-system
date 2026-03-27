package com.esra.realestate.controller;

import com.esra.realestate.dto.request.AgencyCreateRequest;
import com.esra.realestate.dto.response.AgencyResponse;
import com.esra.realestate.service.AgencyService;
import com.esra.realestate.dto.request.AgencyUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
    @PutMapping("/{id}")
    public AgencyResponse updateAgency(@PathVariable("id") Long id,
                                       @Valid @RequestBody AgencyUpdateRequest request) {
        return agencyService.update(id, request);
    }
    @PostMapping
    public AgencyResponse createAgency(@Valid @RequestBody AgencyCreateRequest request) {
        return agencyService.save(request);
    }

    @GetMapping("/{id}")
    public AgencyResponse getAgencyById(@PathVariable("id") Long id) {
        return agencyService.findById(id);
    }

    @GetMapping("/create-sample")
    public AgencyResponse createSampleAgency() {
        AgencyCreateRequest request = new AgencyCreateRequest();
        request.setBusinessName("Esra Emlak");
        request.setAuthorizedPerson("Esra Yılmaz");
        request.setAddress("Ankara, Türkiye");
        request.setPhone("03120000000");
        request.setFax("03120000001");

        return agencyService.save(request);
    }
}