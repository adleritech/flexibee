package com.adleritech.flexibee.core.api.domain;

import org.simpleframework.xml.Attribute;


public abstract class Winstrom {

    @Attribute(name = "version", empty = "1.0")
    private String version;

}
