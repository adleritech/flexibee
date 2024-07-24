package net.testuje.app.flexibee.core.api.transformers;

import org.simpleframework.xml.transform.Transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTransform implements Transform<LocalDate> {

    @Override
    public LocalDate read(String s) throws Exception {
        return LocalDate.parse(s, DateTimeFormatter.ISO_OFFSET_DATE);
    }

    @Override
    public String write(LocalDate instant) throws Exception {
        return instant.toString();
    }

}
