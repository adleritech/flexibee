package com.adleritech.flexibee.core.api.transformers;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.Matcher;

import java.time.Instant;

public class Factory {

    public static Persister persister() {
        return new Persister(matchers());
    }

    public static Matcher matchers() {
        return type -> {
            if (type.isEnum()) {
                return new EnumTransform(type);
            } else if (type.isInstance(Instant.now())) {
                return new InstantTransform();
            }
            return null;
        };
    }

}
