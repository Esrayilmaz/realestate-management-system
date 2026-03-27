package com.esra.realestate.enums;

public enum PropertyType {

    APARTMENT("Daire"),
    HOUSE("Ev"),
    OFFICE("Ofis"),
    LAND("Arsa");

    private final String label;

    PropertyType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}