package com.adleritech.flexibee.core.api.domain;

public enum IssuedInvoiceItemType {

    GENERAL("typPolozky.obecny"),
    DEPOSIT("typPolozky.odpocetZalohy");

    private final String label;

    IssuedInvoiceItemType(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
