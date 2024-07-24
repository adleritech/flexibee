package net.testuje.app.flexibee.core.api.domain;

public enum PriceKind {

    withVat("typCeny.sDphKoef");

    private final String label;

    PriceKind(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }
}
