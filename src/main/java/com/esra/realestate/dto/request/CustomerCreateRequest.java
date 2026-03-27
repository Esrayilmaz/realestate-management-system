package com.esra.realestate.dto.request;

import com.esra.realestate.enums.CustomerType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateRequest {

    @NotBlank(message = "Ad boş bırakılamaz.")
    private String firstName;

    @NotBlank(message = "Soyad boş bırakılamaz.")
    private String lastName;

    private String homePhone;

    @NotBlank(message = "Cep telefonu boş bırakılamaz.")
    private String mobilePhone;

    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    @NotBlank(message = "E-posta boş bırakılamaz.")
    private String email;

    @NotNull(message = "Müşteri tipi seçilmelidir.")
    private CustomerType customerType;

    private String notes;
}