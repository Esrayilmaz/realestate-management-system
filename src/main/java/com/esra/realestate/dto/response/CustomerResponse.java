package com.esra.realestate.dto.response;

import com.esra.realestate.enums.CustomerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private CustomerType customerType;
    private String notes;
}