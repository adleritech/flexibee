package net.testuje.app.flexibee.core.api.domain;

public enum PaymentMethod {

    transfer("formaUhr.prevod"),
    cash("formaUhr.hotove"),
    cheque("formaUhr.slozenka"),
    cashOnDelivery("formaUhr.dobirka"),
    card("formaUhr.platKart"),
    credit("formaUhr.zapocet"),
    undefined("formaUhr.nespec");

    private final String label;

    PaymentMethod(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
