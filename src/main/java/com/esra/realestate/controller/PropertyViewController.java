package com.esra.realestate.controller;

import com.esra.realestate.dto.request.PropertyCreateRequest;
import com.esra.realestate.dto.request.PropertyUpdateRequest;
import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyStatus;
import com.esra.realestate.enums.PropertyType;
import com.esra.realestate.service.CustomerService;
import com.esra.realestate.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/properties/view")
public class PropertyViewController {

    private final PropertyService propertyService;
    private final CustomerService customerService;

    public PropertyViewController(PropertyService propertyService, CustomerService customerService) {
        this.propertyService = propertyService;
        this.customerService = customerService;
    }

    @GetMapping
    public String propertyListPage(Model model) {
        model.addAttribute("properties", propertyService.findAll());
        return "property/list";
    }

    @GetMapping("/new")
    public String newPropertyForm(Model model) {
        model.addAttribute("propertyForm", new PropertyCreateRequest());
        addFormData(model);
        model.addAttribute("formAction", "/properties/view/new");
        model.addAttribute("formTitle", "Yeni Emlak");
        return "property/form";
    }

    @PostMapping("/new")
    public String createProperty(@Valid @ModelAttribute("propertyForm") PropertyCreateRequest request,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            addFormData(model);
            model.addAttribute("formAction", "/properties/view/new");
            model.addAttribute("formTitle", "Yeni Emlak");
            return "property/form";
        }

        propertyService.save(request);
        return "redirect:/properties/view";
    }

    @GetMapping("/edit/{id}")
    public String editPropertyForm(@PathVariable("id") Long id, Model model) {
        var property = propertyService.findById(id);

        PropertyUpdateRequest request = new PropertyUpdateRequest();
        request.setTitle(property.getTitle());
        request.setDescription(property.getDescription());
        request.setListingType(property.getListingType());
        request.setPropertyType(property.getPropertyType());
        request.setCity(property.getCity());
        request.setDistrict(property.getDistrict());
        request.setAddress(property.getAddress());
        request.setSquareMeters(property.getSquareMeters());
        request.setRoomCount(property.getRoomCount());
        request.setFloorNumber(property.getFloorNumber());
        request.setBuildingFloors(property.getBuildingFloors());
        request.setHeatingType(property.getHeatingType());
        request.setFurnished(property.getFurnished());
        request.setPrice(property.getPrice());
        request.setStatus(property.getStatus());
        request.setOwnerCustomerId(property.getOwnerCustomerId());

        model.addAttribute("propertyForm", request);
        addFormData(model);
        model.addAttribute("formAction", "/properties/view/edit/" + id);
        model.addAttribute("formTitle", "Emlak Düzenle");
        return "property/form";
    }

    @PostMapping("/edit/{id}")
    public String updateProperty(@PathVariable("id") Long id,
                                 @Valid @ModelAttribute("propertyForm") PropertyUpdateRequest request,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            addFormData(model);
            model.addAttribute("formAction", "/properties/view/edit/" + id);
            model.addAttribute("formTitle", "Emlak Düzenle");
            return "property/form";
        }

        propertyService.update(id, request);
        return "redirect:/properties/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable("id") Long id) {
        propertyService.delete(id);
        return "redirect:/properties/view";
    }

    @GetMapping("/print/{id}")
    public String printPropertyPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("property", propertyService.findById(id));
        return "property/print";
    }

    private void addFormData(Model model) {
        model.addAttribute("customers", customerService.findPropertyOwners());
        model.addAttribute("listingTypes", ListingType.values());
        model.addAttribute("propertyTypes", PropertyType.values());
        model.addAttribute("heatingTypes", HeatingType.values());
        model.addAttribute("propertyStatuses", PropertyStatus.values());
    }
}