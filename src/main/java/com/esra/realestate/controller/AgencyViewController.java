package com.esra.realestate.controller;

import com.esra.realestate.dto.request.AgencyUpdateRequest;
import com.esra.realestate.service.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AgencyViewController {

    private final AgencyService agencyService;

    public AgencyViewController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping("/agency/view")
    public String agencyViewPage(Model model) {
        model.addAttribute("agency", agencyService.findById(1L));
        return "agency/view";
    }

    // 🔥 EDIT FORM
    @GetMapping("/agency/view/edit")
    public String editAgencyForm(Model model) {
        var agency = agencyService.findById(1L);

        AgencyUpdateRequest request = new AgencyUpdateRequest();
        request.setBusinessName(agency.getBusinessName());
        request.setAuthorizedPerson(agency.getAuthorizedPerson());
        request.setPhone(agency.getPhone());
        request.setFax(agency.getFax());
        request.setAddress(agency.getAddress());

        model.addAttribute("agencyForm", request);
        return "agency/form";
    }

    // 🔥 UPDATE
    @PostMapping("/agency/view/edit")
    public String updateAgency(@ModelAttribute("agencyForm") AgencyUpdateRequest request) {
        agencyService.update(1L, request);
        return "redirect:/agency/view";
    }
}