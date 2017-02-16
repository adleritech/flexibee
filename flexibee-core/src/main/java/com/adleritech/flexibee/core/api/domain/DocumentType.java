package com.adleritech.flexibee.core.api.domain;

public enum DocumentType {

    invoice("code:FAKTURA");

    String label;

    DocumentType(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
