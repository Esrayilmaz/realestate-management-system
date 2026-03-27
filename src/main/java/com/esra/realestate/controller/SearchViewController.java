package com.esra.realestate.controller;

import com.esra.realestate.dto.request.PropertySearchRequestDto;
import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyType;
import com.esra.realestate.service.CustomerService;
import com.esra.realestate.service.PropertySearchService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SearchViewController {

    private final PropertySearchService propertySearchService;
    private final CustomerService customerService;

    public SearchViewController(PropertySearchService propertySearchService,
                                CustomerService customerService) {
        this.propertySearchService = propertySearchService;
        this.customerService = customerService;
    }

    @GetMapping("/search/view")
    public String searchFormPage(Model model) {
        model.addAttribute("searchRequest", new PropertySearchRequestDto());
        addFormData(model);
        return "search/form";
    }

    @PostMapping("/search/view")
    public String searchResults(@Valid @ModelAttribute("searchRequest") PropertySearchRequestDto searchRequest,
                                BindingResult bindingResult,
                                Model model) {

        addFormData(model);

        if (bindingResult.hasErrors()) {
            return "search/form";
        }

        model.addAttribute("results", propertySearchService.search(searchRequest));
        return "search/results";
    }

    private void addFormData(Model model) {
        model.addAttribute("customers", customerService.findPropertyOwners());
        model.addAttribute("listingTypes", ListingType.values());
        model.addAttribute("propertyTypes", PropertyType.values());
        model.addAttribute("heatingTypes", HeatingType.values());
    }
}