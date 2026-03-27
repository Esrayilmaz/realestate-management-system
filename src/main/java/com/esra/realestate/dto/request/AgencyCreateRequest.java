package com.esra.realestate.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgencyCreateRequest {

    @NotBlank(message = "İşletme adı boş olamaz")
    private String businessName;

    @NotBlank(message = "Yetkili kişi boş olamaz")
    private String authorizedPerson;

    private String address;
    private String phone;
    private String fax;
}