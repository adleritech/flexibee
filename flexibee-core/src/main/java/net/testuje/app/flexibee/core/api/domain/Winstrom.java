package net.testuje.app.flexibee.core.api.domain;

import org.simpleframework.xml.Attribute;


abstract class Winstrom {

    @Attribute(name = "version", empty = "1.0")
    private String version;

}
