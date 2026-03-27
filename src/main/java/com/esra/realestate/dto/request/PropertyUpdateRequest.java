package com.esra.realestate.dto.request;

import com.esra.realestate.enums.HeatingType;
import com.esra.realestate.enums.ListingType;
import com.esra.realestate.enums.PropertyStatus;
import com.esra.realestate.enums.PropertyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyUpdateRequest {

    @NotBlank(message = "Başlık boş bırakılamaz.")
    private String title;

    private String description;

    @NotNull(message = "İlan türü seçilmelidir.")
    private ListingType listingType;

    @NotNull(message = "Emlak türü seçilmelidir.")
    private PropertyType propertyType;

    @NotBlank(message = "Şehir boş bırakılamaz.")
    private String city;

    @NotBlank(message = "İlçe boş bırakılamaz.")
    private String district;

    private String address;

    @NotNull(message = "Metrekare bilgisi girilmelidir.")
    @Positive(message = "Metrekare 0'dan büyük olmalıdır.")
    private Integer squareMeters;

    @NotNull(message = "Oda sayısı girilmelidir.")
    @Positive(message = "Oda sayısı 0'dan büyük olmalıdır.")
    private Integer roomCount;

    private Integer floorNumber;
    private Integer buildingFloors;

    @NotNull(message = "Isınma türü seçilmelidir.")
    private HeatingType heatingType;

    private Boolean furnished;

    @NotNull(message = "Fiyat girilmelidir.")
    @Positive(message = "Fiyat 0'dan büyük olmalıdır.")
    private Double price;

    @NotNull(message = "Durum seçilmelidir.")
    private PropertyStatus status;

    @NotNull(message = "Müşteri sahibi seçilmelidir.")
    private Long ownerCustomerId;
}