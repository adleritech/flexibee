package net.testuje.app.flexibee.core.api.domain;

public enum RoundingPrecision {

    NONE("zaokrNa.zadne"),
    HUNDREDTHS("zaokrNa.setiny"),
    UNITS("zaokrNa.jednotky");

    private final String label;

    RoundingPrecision(String s) {
        label = s;
    }

    @Override
    public String toString() {
        return label;
    }

}
