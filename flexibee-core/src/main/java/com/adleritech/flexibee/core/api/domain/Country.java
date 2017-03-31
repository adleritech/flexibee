package com.adleritech.flexibee.core.api.domain;

public enum Country {

    cz("code:CZ"),
    sk("code:SK");

    public final String code;

    Country(String s) {
        code = s;
    }

    @Override
    public String toString() {
        return code;
    }

}
