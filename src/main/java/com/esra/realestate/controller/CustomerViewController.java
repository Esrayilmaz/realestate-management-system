package com.esra.realestate.controller;

import com.esra.realestate.dto.request.CustomerCreateRequest;
import com.esra.realestate.dto.request.CustomerUpdateRequest;
import com.esra.realestate.enums.CustomerType;
import com.esra.realestate.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers/view")
public class CustomerViewController {

    private final CustomerService customerService;

    public CustomerViewController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String customerListPage(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/new")
    public String newCustomerForm(Model model) {
        model.addAttribute("customerForm", new CustomerCreateRequest());
        model.addAttribute("customerTypes", CustomerType.values());
        model.addAttribute("formAction", "/customers/view/new");
        model.addAttribute("formTitle", "Yeni Müşteri");
        model.addAttribute("isEdit", false);
        return "customer/form";
    }

    @PostMapping("/new")
    public String createCustomer(@Valid @ModelAttribute("customerForm") CustomerCreateRequest request,
                                 org.springframework.validation.BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", CustomerType.values());
            model.addAttribute("formAction", "/customers/view/new");
            model.addAttribute("formTitle", "Yeni Müşteri");
            model.addAttribute("isEdit", false);
            return "customer/form";
        }

        customerService.save(request);
        return "redirect:/customers/view";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable("id") Long id, Model model) {
        var customer = customerService.findById(id);

        CustomerUpdateRequest request = new CustomerUpdateRequest();
        request.setFirstName(customer.getFirstName());
        request.setLastName(customer.getLastName());
        request.setHomePhone(customer.getHomePhone());
        request.setMobilePhone(customer.getMobilePhone());
        request.setEmail(customer.getEmail());
        request.setCustomerType(customer.getCustomerType());
        request.setNotes(customer.getNotes());

        model.addAttribute("customerForm", request);
        model.addAttribute("customerTypes", CustomerType.values());
        model.addAttribute("formAction", "/customers/view/edit/" + id);
        model.addAttribute("formTitle", "Müşteri Bilgisini Güncelle");
        model.addAttribute("isEdit", true);
        return "customer/form";
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Long id,
                                 @Valid @ModelAttribute("customerForm") CustomerUpdateRequest request,
                                 org.springframework.validation.BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", CustomerType.values());
            model.addAttribute("formAction", "/customers/view/edit/" + id);
            model.addAttribute("formTitle", "Müşteri Düzenle");
            model.addAttribute("isEdit", true);
            return "customer/form";
        }

        customerService.update(id, request);
        return "redirect:/customers/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id,
                                 org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        try {
            customerService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Müşteri başarıyla silindi.");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/customers/view";
    }
}