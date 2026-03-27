package com.esra.realestate.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgencyResponse {

    private Long id;
    private String businessName;
    private String authorizedPerson;
    private String address;
    private String phone;
    private String fax;
}