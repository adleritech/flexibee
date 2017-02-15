package com.adleritech.flexibee.core.api.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDate;

public class LocalDateTransform implements Transform<LocalDate> {

    @Override
    public LocalDate read(String s) throws Exception {
        return LocalDate.parse(s);
    }

    @Override
    public String write(LocalDate instant) throws Exception {
        return instant.toString();
    }

}
