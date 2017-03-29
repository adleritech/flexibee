package com.adleritech.flexibee.core.api.domain;

import com.adleritech.flexibee.core.api.transformers.Factory;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuedInvoiceTest {

    @Test
    public void parseFromXmlToObject() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<winstrom version=\"1.0\">\n" +
                "   <adresar>\n" +
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


        Serializer serializer = new Persister(Factory.matchers());

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
                "    <adresar>\n" +
                "        <id>code</id>\n" +
                "        <ic>12345678</ic>\n" +
                "        <psc>150 </psc>\n" +
                "        <nazev>Papírnictví</nazev>\n" +
                "        <mesto>Praha </mesto>\n" +
                "        <dic>CZ7002051235</dic>\n" +
                "        <ulice>Plzeňská</ulice>\n" +
                "        <kod>PBENDA</kod>\n" +
                "    </adresar>\n" +
                "    <faktura-vydana>\n" +
                "        <typDokl>code:FAKTURA</typDokl>\n" +
                "        <firma>code:PBENDA</firma>\n" +
                "    </faktura-vydana>\n" +
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
        Serializer serializer = new Persister(Factory.matchers());
        serializer.write(envelope, result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }

    @Test
    public void createInvoiceWithItems() throws Exception {
        WinstromRequest envelope = WinstromRequest.builder()
                .issuedInvoice(IssuedInvoice.builder()
                        .company("code:ABCFIRM1#")
                        .documentType("code:FAKTURA")
                        .issued(LocalDate.of(2017, 4, 2))
                        .items(Arrays.asList(
                                IssuedInvoiceItem.builder()
                                        .name("Bla bla jizdne")
                                        .amount(1)
                                        .sumVat(1500d)
                                        .unitPrice(7500d)
                                        .sumTotal(9000d)
                                        .priceKind(PriceKind.withVat)
                                        .vatRate(21d).build()
                        ))
                        .build()).build();

        // Maybe you have to correct this or use another / no Locale

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(envelope, result);

        String xml = "<winstrom version=\"1.0\">\n" +
                "    <faktura-vydana>\n" +
                "        <typDokl>code:FAKTURA</typDokl>\n" +
                "        <firma>code:ABCFIRM1#</firma>\n" +
                "        <datVyst>2017-04-02</datVyst>\n" +
                "        <polozkyFaktury class=\"java.util.Arrays$ArrayList\">\n" +
                "            <faktura-vydana-polozka>\n" +
                "                <nazev>Bla bla jizdne</nazev>\n" +
                "                <mnozBaleni>1</mnozBaleni>\n" +
                "                <szbDph>21.0</szbDph>\n" +
                "                <sumDph>1500.0</sumDph>\n" +
                "                <sumCelkem>9000.0</sumCelkem>\n" +
                "                <cenaMj>7500.0</cenaMj>\n" +
                "                <typCenyDphK>typCeny.sDphKoef</typCenyDphK>\n" +
                "            </faktura-vydana-polozka>\n" +
                "        </polozkyFaktury>\n" +
                "    </faktura-vydana>\n" +
                "</winstrom>";
        assertThat(result.toString()).isXmlEqualTo(xml);
    }

    @Test
    public void LocalDateIsParsed() throws Exception {
        WinstromRequest envelope = WinstromRequest.builder()
                .issuedInvoice(IssuedInvoice.builder()
                        .issued(LocalDate.of(2017, 4, 2))
                        .build()).build();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(envelope, result);

        String xml = "<winstrom version=\"1.0\">\n" +
                "    <faktura-vydana>\n" +
                "        <datVyst>2017-04-02</datVyst>\n" +
                "    </faktura-vydana>\n" +
                "</winstrom>";
        assertThat(result.toString()).isXmlEqualTo(xml);
    }

    @Test
    public void invoiceWithAddressBook() throws Exception {
        WinstromRequest envelope = WinstromRequest.builder()
                .addressBook(AddressBook.builder()
                        .name("Československá obchodní banka, a. s.")
                        .vatId("CZ00001350")
                        .regNo("00001350")
                        .city("Praha 5")
                        .street("Radlická 333/150")
                        .postCode("15057")
                        .build())
                .issuedInvoice(IssuedInvoice.builder()
                        .company("code:ČESKOSLOVENSKÁ0")
                        .documentType("code:FAKTURA")
                        .items(Arrays.asList(
                                IssuedInvoiceItem.builder()
                                        .name("Bla bla jizdne")
                                        .amount(1)
                                        .sumVat(1500d)
                                        .unitPrice(7500d)
                                        .sumTotal(9000d)
                                        .vatRate(21d).build()
                        ))
                        .build()).build();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(envelope, result);

        String xml = "<winstrom version=\"1.0\">\n" +
                "    <adresar>\n" +
                "        <ic>00001350</ic>\n" +
                "        <psc>15057</psc>\n" +
                "        <nazev>Československá obchodní banka, a. s.</nazev>\n" +
                "        <mesto>Praha 5</mesto>\n" +
                "        <dic>CZ00001350</dic>\n" +
                "        <ulice>Radlická 333/150</ulice>\n" +
                "    </adresar>\n" +
                "    <faktura-vydana>\n" +
                "        <typDokl>code:FAKTURA</typDokl>\n" +
                "        <firma>code:ČESKOSLOVENSKÁ0</firma>\n" +
                "        <polozkyFaktury class=\"java.util.Arrays$ArrayList\">\n" +
                "            <faktura-vydana-polozka>\n" +
                "                <nazev>Bla bla jizdne</nazev>\n" +
                "                <mnozBaleni>1</mnozBaleni>\n" +
                "                <szbDph>21.0</szbDph>\n" +
                "                <sumDph>1500.0</sumDph>\n" +
                "                <sumCelkem>9000.0</sumCelkem>\n" +
                "                <cenaMj>7500.0</cenaMj>\n" +
                "            </faktura-vydana-polozka>\n" +
                "        </polozkyFaktury>\n" +
                "    </faktura-vydana>\n" +
                "</winstrom>";
        assertThat(result.toString()).isXmlEqualTo(xml);
    }
}
