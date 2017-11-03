package com.adleritech.flexibee.core.api.domain;

public enum PaymentStatus {

    MANUALLY("stavUhr.uhrazenoRucne");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
