package com.adleritech.flexibee.core.api.domain;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Data
@Root(strict = false)
public class Results {

    @Element(name = "result")
    private Result result;

}
