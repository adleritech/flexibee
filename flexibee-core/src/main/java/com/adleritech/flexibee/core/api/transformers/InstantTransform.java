package com.adleritech.flexibee.core.api.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.Instant;

public class InstantTransform implements Transform<Instant> {

    @Override
    public Instant read(String s) throws Exception {
        return Instant.parse(s);
    }

    @Override
    public String write(Instant instant) throws Exception {
        return instant.toString();
    }

}
