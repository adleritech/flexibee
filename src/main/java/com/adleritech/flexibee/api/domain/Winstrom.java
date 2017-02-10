package com.adleritech.flexibee.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "winstrom")
public class Winstrom {

    @Element(name="faktura-vydana")
    private IssuedInvoice issuedInvoice;

    @Element(name="adresar")
    private AddressBook addressBook;

    @Attribute(name="version", empty = "1.0")
    private String version;

}
