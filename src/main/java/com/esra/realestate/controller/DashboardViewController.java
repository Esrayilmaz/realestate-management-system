package com.esra.realestate.controller;

import com.esra.realestate.entity.Property;
import com.esra.realestate.repository.AgencyRepository;
import com.esra.realestate.repository.CustomerRepository;
import com.esra.realestate.repository.PropertyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardViewController {

    private final CustomerRepository customerRepository;
    private final PropertyRepository propertyRepository;
    private final AgencyRepository agencyRepository;

    public DashboardViewController(CustomerRepository customerRepository,
                                   PropertyRepository propertyRepository,
                                   AgencyRepository agencyRepository) {
        this.customerRepository = customerRepository;
        this.propertyRepository = propertyRepository;
        this.agencyRepository = agencyRepository;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        List<Property> properties = propertyRepository.findAll();

        long activePropertyCount = properties.stream()
                .filter(property -> property.getStatus() != null && property.getStatus().name().equals("ACTIVE"))
                .count();

        long rentedPropertyCount = properties.stream()
                .filter(property -> property.getStatus() != null && property.getStatus().name().equals("RENTED"))
                .count();

        long soldPropertyCount = properties.stream()
                .filter(property -> property.getStatus() != null && property.getStatus().name().equals("SOLD"))
                .count();

        long passivePropertyCount = properties.stream()
                .filter(property -> property.getStatus() != null && property.getStatus().name().equals("PASSIVE"))
                .count();

        long rentListingCount = properties.stream()
                .filter(property -> property.getListingType() != null && property.getListingType().name().equals("RENT"))
                .count();

        long saleListingCount = properties.stream()
                .filter(property -> property.getListingType() != null && property.getListingType().name().equals("SALE"))
                .count();

        model.addAttribute("customerCount", customerRepository.count());
        model.addAttribute("propertyCount", propertyRepository.count());
        model.addAttribute("agencyCount", agencyRepository.count());
        model.addAttribute("activePropertyCount", activePropertyCount);

        model.addAttribute("activeStatusCount", activePropertyCount);
        model.addAttribute("rentedStatusCount", rentedPropertyCount);
        model.addAttribute("soldStatusCount", soldPropertyCount);
        model.addAttribute("passiveStatusCount", passivePropertyCount);

        model.addAttribute("rentListingCount", rentListingCount);
        model.addAttribute("saleListingCount", saleListingCount);

        return "dashboard/index";
    }
}