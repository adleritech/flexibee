package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Root(name = "winstrom")
@org.simpleframework.xml.Order(elements = {"adresar", "zakazka", "faktura-vydana"})
public class WinstromRequest extends Winstrom {

    @Element(name = "adresar", required = false)
    private AddressBook addressBook;

    @Element(name = "zakazka", required = false)
    private Order order;

    @Element(name = "faktura-vydana", required = false)
    private IssuedInvoice issuedInvoice;

    @Element(name = "interni-doklad", required = false)
    private InternalDocument internalDocument;

    @Element(name = "pohledavka", required = false)
    private Receivable receivable;

    @Element(name = "banka", required = false)
    private Bank bank;

}


