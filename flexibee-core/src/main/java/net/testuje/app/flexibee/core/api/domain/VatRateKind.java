package net.testuje.app.flexibee.core.api.domain;

public enum VatRateKind {
    /**
     * typSzbDph.dphOsv
     * snížená (typSzbDph.dphSniz)
     * 2. snížená (typSzbDph.dphSniz2)
     * základní (typSzbDph.dphZakl
     */

    FREE("typSzbDph.dphOsv"),
    LOWER("typSzbDph.dphSniz"),
    LOWER2("typSzbDph.dphSniz2"),
    BASIC("typSzbDph.dphZakl");

    private final String label;

    VatRateKind(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
