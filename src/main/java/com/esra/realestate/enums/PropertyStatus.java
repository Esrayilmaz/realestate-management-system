package com.esra.realestate.enums;

public enum PropertyStatus {

    ACTIVE("Aktif"),
    RENTED("Kiralandı"),
    SOLD("Satıldı"),
    PASSIVE("Pasif");

    private final String label;

    PropertyStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}