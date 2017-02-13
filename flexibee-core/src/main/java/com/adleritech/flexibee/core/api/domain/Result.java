package com.adleritech.flexibee.core.api.domain;


import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Data
@Root(strict = false)
public class Result {

    @Element(name = "id", required = false)
    private String id;

    @Element(name = "ref", required = false)
    private String ref;

}
