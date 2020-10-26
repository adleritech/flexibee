package com.adleritech.flexibee.core.api.domain;

import lombok.*;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Root(name = "winstrom")
public class WinstromRequest extends Winstrom {

    @ElementList(name = "adresar", required = false, inline = true)
    private ArrayList<AddressBook> addressBooks = new ArrayList<>();

    @ElementList(name = "zakazka", required = false, inline = true)
    private ArrayList<Order> orders = new ArrayList<>();

    @ElementList(name = "faktura-prijata", required = false, inline = true)
    private ArrayList<ReceivedInvoice> receivedInvoices = new ArrayList<>();

    @ElementList(name = "faktura-vydana", required = false, inline = true)
    private ArrayList<IssuedInvoice> issuedInvoices = new ArrayList<>();

    @ElementList(name = "interni-doklad", required = false, inline = true)
    private ArrayList<InternalDocument> internalDocuments = new ArrayList<>();

    @ElementList(name = "pohledavka", required = false, inline = true)
    private ArrayList<Receivable> receivables = new ArrayList<>();

    @ElementList(name = "banka", required = false, inline = true)
    private ArrayList<Bank> banks = new ArrayList<>();

    @ElementList(name = "zavazek", required = false, inline = true)
    private ArrayList<Obligation> obligations = new ArrayList<>();

}


