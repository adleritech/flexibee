package com.adleritech.flexibee.core.api.domain;

public enum PaymentBindingRemainderType {

    PROHIBITED("ne");

    private final String label;

    PaymentBindingRemainderType(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
