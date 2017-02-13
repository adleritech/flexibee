package com.adleritech.flexibee.core.api.domain;

public enum PriceKind {

    a("typCeny.sDphKoef");

    String label;

    PriceKind(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }
}
