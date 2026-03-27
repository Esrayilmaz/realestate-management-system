package com.esra.realestate.enums;

public enum HeatingType {

    NATURAL_GAS("Doğalgaz"),
    CENTRAL("Merkezi Sistem"),
    STOVE("Soba"),
    AIR_CONDITIONER("Klima");

    private final String label;

    HeatingType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}