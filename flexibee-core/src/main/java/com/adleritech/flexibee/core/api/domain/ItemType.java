package com.adleritech.flexibee.core.api.domain;

public enum ItemType {

    GENERAL("typPolozky.obecny"),
    CATALOGUE("typPolozky.katalog"),
    ACCOUNTING("typPolozky.ucetni"),
    TEXT("typPolozky.text");

    private final String label;

    ItemType(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
