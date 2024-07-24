package net.testuje.app.flexibee.core.api.domain;

public enum PaymentStatus {

    FULLY("stavUhr.uhrazeno"),
    PARTIALLY("stavUhr.castUhr"),
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
