package net.testuje.app.flexibee.core.api.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "winstrom")
public class ReceivedInvoiceResponse {

    @Attribute(name = "version")
    private String version;

    @Element(name = "faktura-prijata")
    private ReceivedInvoice receivedInvoice;

}
