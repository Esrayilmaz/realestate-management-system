package com.esra.realestate.enums;

public enum CustomerType {

    BUYER("Alıcı"),
    SELLER("Satıcı"),
    OWNER("Mülk Sahibi");

    private final String label;

    CustomerType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}