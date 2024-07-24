package net.testuje.app.flexibee.core.api.domain;

public enum IssuedInvoiceItemType {

    GENERAL("typPolozky.obecny"),
    CATALOGUE("typPolozky.katalog"),
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
