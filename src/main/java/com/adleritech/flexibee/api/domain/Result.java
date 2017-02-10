package com.adleritech.flexibee.api.domain;

import lombok.Data;
import org.simpleframework.xml.Element;

@Data
public class Result {

    @Element(name = "id")
    private String id;

}
