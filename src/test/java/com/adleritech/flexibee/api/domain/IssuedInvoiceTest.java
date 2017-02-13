package com.adleritech.flexibee.api.domain;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuedInvoiceTest {

    @Test
    public void parseFromXmlToObject() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<winstrom version=\"1.0\">\n" +
                "   <adresar update=\"ignore\">\n" +
                "      <kod>PBENDA</kod>\n" +
                "      <id>code:PBENDA</id>\n" +
                "      <nazev>Papírnictví Benda</nazev>\n" +
                "      <ulice>Plzeňská 65</ulice>\n" +
                "      <mesto>Praha 5</mesto>\n" +
                "      <psc>150 00</psc>\n" +
                "      <ic>12345678</ic>\n" +
                "      <dic>CZ7002051235</dic>\n" +
                "   </adresar>\n" +
                "   <faktura-vydana>\n" +
                "      <firma>code:PBENDA</firma>\n" +
                "      <typDokl>code:FAKTURA</typDokl>\n" +
                "   </faktura-vydana>\n" +
                "</winstrom>";


        Serializer serializer = new Persister();

        WinstromRequest example = serializer.read(WinstromRequest.class, xml);

        assertThat(example.getAddressBook()).isNotNull();
        assertThat(example.getAddressBook().getCode()).isEqualTo("PBENDA");
        assertThat(example.getAddressBook().getId()).isEqualTo("code:PBENDA");
        assertThat(example.getAddressBook().getName()).isEqualTo("Papírnictví Benda");
        assertThat(example.getAddressBook().getStreet()).isEqualTo("Plzeňská 65");
        assertThat(example.getAddressBook().getCity()).isEqualTo("Praha 5");
        assertThat(example.getAddressBook().getRegNo()).isEqualTo("12345678");
        assertThat(example.getAddressBook().getPostCode()).isEqualTo("150 00");
        assertThat(example.getAddressBook().getVatId()).isEqualTo("CZ7002051235");

        assertThat(example.getIssuedInvoice()).isNotNull();
        assertThat(example.getIssuedInvoice().getCompany()).isEqualTo("code:PBENDA");
        assertThat(example.getIssuedInvoice().getDocumentType()).isEqualTo("code:FAKTURA");
    }

    @Test
    public void parseFromObjectToXml() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "   <faktura-vydana>\n" +
                "      <typDokl>code:FAKTURA</typDokl>\n" +
                "      <firma>code:PBENDA</firma>\n" +
                "   </faktura-vydana>\n" +
                "   <adresar update=\"ignore\">\n" +
                "      <id>code</id>\n" +
                "      <ic>12345678</ic>\n" +
                "      <psc>150 </psc>\n" +
                "      <nazev>Papírnictví</nazev>\n" +
                "      <mesto>Praha </mesto>\n" +
                "      <dic>CZ7002051235</dic>\n" +
                "      <ulice>Plzeňská</ulice>\n" +
                "      <kod>PBENDA</kod>\n" +
                "   </adresar>\n" +
                "</winstrom>";

        WinstromRequest envelope = WinstromRequest.builder()
                .issuedInvoice(
                        IssuedInvoice.builder()
                                .company("code:PBENDA")
                                .documentType("code:FAKTURA")
                                .build())
                .addressBook(
                        AddressBook.builder()
                                .code("PBENDA")
                                .id("code")
                                .name("Papírnictví")
                                .street("Plzeňská")
                                .city("Praha ")
                                .postCode("150 ")
                                .regNo("12345678")
                                .vatId("CZ7002051235")
                                .build())
                .build();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(envelope, result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }

}
