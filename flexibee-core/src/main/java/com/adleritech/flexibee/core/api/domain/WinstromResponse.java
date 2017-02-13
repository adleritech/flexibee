package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "winstrom", strict = false)
public class WinstromResponse extends Winstrom {

    @Element(name = "success")
    private boolean success;

    @Element(name = "results", required = false)
    private Results results;

}
