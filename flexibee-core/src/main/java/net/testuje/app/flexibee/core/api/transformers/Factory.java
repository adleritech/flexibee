package net.testuje.app.flexibee.core.api.transformers;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.Matcher;

import java.time.LocalDate;

public class Factory {

    public static Persister persister() {
        return new Persister(matchers());
    }

    public static Matcher matchers() {
        return type -> {
            if (type.isEnum()) {
                return new EnumTransform(type);
            } else if (type.isInstance(LocalDate.now())) {
                return new LocalDateTransform();
            }
            return null;
        };
    }

}
