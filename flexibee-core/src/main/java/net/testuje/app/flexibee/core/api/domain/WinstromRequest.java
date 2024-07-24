package net.testuje.app.flexibee.core.api.domain;

import lombok.*;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Root(name = "winstrom")
public class WinstromRequest extends Winstrom {

    @ElementList(name = "adresar", required = false, inline = true)
    @Singular
    private List<AddressBook> addressBooks = new ArrayList<>();

    @ElementList(name = "zakazka", required = false, inline = true)
    @Singular
    private List<Order> orders = new ArrayList<>();

    @ElementList(name = "faktura-prijata", required = false, inline = true)
    @Singular
    private List<ReceivedInvoice> receivedInvoices = new ArrayList<>();

    @ElementList(name = "faktura-vydana", required = false, inline = true)
    @Singular
    private List<IssuedInvoice> issuedInvoices = new ArrayList<>();

    @ElementList(name = "interni-doklad", required = false, inline = true)
    @Singular
    private List<InternalDocument> internalDocuments = new ArrayList<>();

    @ElementList(name = "pohledavka", required = false, inline = true)
    @Singular
    private List<Receivable> receivables = new ArrayList<>();

    @ElementList(name = "banka", required = false, inline = true)
    @Singular
    private List<Bank> banks = new ArrayList<>();

    @ElementList(name = "zavazek", required = false, inline = true)
    @Singular
    private List<Obligation> obligations = new ArrayList<>();

}


