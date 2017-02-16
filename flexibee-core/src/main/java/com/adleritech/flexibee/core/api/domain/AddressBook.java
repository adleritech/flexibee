package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {

    @Attribute(name = "update", empty = "ignore")
    private Update update;

    @Element(name = "id", required = false)
    private String id;

    @Element(name = "ic")
    private String regNo;

    @Element(name = "psc")
    private String postCode;

    @Element(name = "nazev")
    private String name;

    @Element(name = "mesto")
    private String city;

    @Element(name = "dic", required = false)
    private String vatId;

    @Element(name = "ulice")
    private String street;

    @Element(name = "kod", required = false)
    private String code;

}
