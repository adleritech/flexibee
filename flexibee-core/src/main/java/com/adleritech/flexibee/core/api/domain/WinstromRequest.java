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
@Root(name = "winstrom")
public class WinstromRequest extends Winstrom {

    @Element(name = "faktura-vydana")
    private IssuedInvoice issuedInvoice;

    @Element(name = "adresar", required = false)
    private AddressBook addressBook;

}


