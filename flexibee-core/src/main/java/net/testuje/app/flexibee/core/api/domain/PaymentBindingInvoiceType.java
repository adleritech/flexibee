package net.testuje.app.flexibee.core.api.domain;

public enum PaymentBindingInvoiceType {

    ISSUED_INVOICE("faktura-vydana");

    private final String label;

    PaymentBindingInvoiceType(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}

