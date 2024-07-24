package net.testuje.app.flexibee.core.api.domain;

public enum AccountMovementType {

    CREDIT("typPohybu.prijem"),
    DEBIT("typPohybu.vydej");

    private final String label;

    AccountMovementType(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
