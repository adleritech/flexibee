package com.adleritech.flexibee.core.api.transformers;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.Matcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Factory {

    private final static DateFormat format = new SimpleDateFormat("EE MMM dd HH:mm:ss z yy", Locale.US);

    public static Persister persister() {
        return new Persister(matchers());
    }

    public static Matcher matchers() {
        return type -> {
            if (type.isEnum()) {
                return new EnumTransform(type);
            } else if (type.isInstance(new Date())) {
                return new DateFormatTransformer(format);
            }
            return null;
        };
    }

}
