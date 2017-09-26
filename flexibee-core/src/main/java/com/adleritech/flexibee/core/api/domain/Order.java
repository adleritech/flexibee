package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @ElementListUnion({
            @ElementList(entry = "id", type = String.class, inline = true, required = false)
    })
    private List<String> id;

    @Element(name = "nazev")
    private String name;

    @Element(name = "firma", required = false)
    private String company;

}
