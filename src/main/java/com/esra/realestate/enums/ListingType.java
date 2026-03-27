package com.esra.realestate.enums;

public enum ListingType {

    RENT("Kiralık"),
    SALE("Satılık");

    private final String label;

    ListingType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}