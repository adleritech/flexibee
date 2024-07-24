package net.testuje.app.flexibee.core.api.domain;

import net.testuje.app.flexibee.core.api.transformers.Factory;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static java.math.BigDecimal.ONE;
import static org.assertj.core.api.Assertions.assertThat;

public class IssuedInvoiceTest {

    @Test
    public void parseFromXmlToObject() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<winstrom version=\"1.0\">\n" +
                "   <adresar>\n" +
                "      <kod>PBENDA</kod>\n" +
                "      <id>ext:33866089</id>\n" +
                "      <id>ext:1976780508</id>\n" +
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

        assertThat(example.getAddressBooks().get(0)).isNotNull();
        assertThat(example.getAddressBooks().get(0).getCode()).isEqualTo("PBENDA");
        assertThat(example.getAddressBooks().get(0).getId()).isEqualTo(Arrays.asList("ext:33866089", "ext:1976780508"));
        assertThat(example.getAddressBooks().get(0).getName()).isEqualTo("Papírnictví Benda");
        assertThat(example.getAddressBooks().get(0).getStreet()).isEqualTo("Plzeňská 65");
        assertThat(example.getAddressBooks().get(0).getCity()).isEqualTo("Praha 5");
        assertThat(example.getAddressBooks().get(0).getRegNo()).isEqualTo("12345678");
        assertThat(example.getAddressBooks().get(0).getPostCode()).isEqualTo("150 00");
        assertThat(example.getAddressBooks().get(0).getVatId()).isEqualTo("CZ7002051235");

        assertThat(example.getIssuedInvoices().get(0)).isNotNull();
        assertThat(example.getIssuedInvoices().get(0).getCompany()).isEqualTo("code:PBENDA");
        assertThat(example.getIssuedInvoices().get(0).getDocumentType()).isEqualTo("code:FAKTURA");
    }

    @Test
    public void parseFromObjectToXml() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "    <adresar>\n" +
                "        <id>123</id>\n" +
                "        <ic>12345678</ic>\n" +
                "        <psc>150 </psc>\n" +
                "        <nazev>Papírnictví</nazev>\n" +
                "        <mesto>Praha </mesto>\n" +
                "        <dic>CZ7002051235</dic>\n" +
                "        <ulice>Plzeňská</ulice>\n" +
                "        <kod>PBENDA</kod>\n" +
                "    </adresar>\n" +
                "    <faktura-vydana>\n" +
                "        <id>456</id>\n" +
                "        <typDokl>code:FAKTURA</typDokl>\n" +
                "        <firma>code:PBENDA</firma>\n" +
                "    </faktura-vydana>\n" +
                "</winstrom>";

        WinstromRequest envelope = WinstromRequest.builder()
                .issuedInvoice(
                        IssuedInvoice.builder()
                                .id(Collections.singletonList("456"))
                                .company("code:PBENDA")
                                .documentType("code:FAKTURA")
                                .build())
                .addressBook(
                        AddressBook.builder()
                                .code("PBENDA")
                                .id(Collections.singletonList("123"))
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
                        .orderNumber("123456789")
                        .items(new IssuedInvoiceItems(
                                IssuedInvoiceItem.builder()
                                        .name("Bla bla jizdne")
                                        .amount(ONE)
                                        .sumVat(BigDecimal.valueOf(1500))
                                        .unitPrice(BigDecimal.valueOf(7500))
                                        .sumTotal(BigDecimal.valueOf(9000))
                                        .priceKind(PriceKind.withVat)
                                        .vatRate(BigDecimal.valueOf(21))
                                        .businessSegment("code:9_ALO")
                                        .build()
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
                "        <polozkyFaktury removeAll=\"false\">\n" +
                "            <faktura-vydana-polozka>\n" +
                "                <nazev>Bla bla jizdne</nazev>\n" +
                "                <mnozBaleni>1</mnozBaleni>\n" +
                "                <szbDph>21</szbDph>\n" +
                "                <sumDph>1500</sumDph>\n" +
                "                <sumCelkem>9000</sumCelkem>\n" +
                "                <cenaMj>7500</cenaMj>\n" +
                "                <typCenyDphK>typCeny.sDphKoef</typCenyDphK>\n" +
                "                <cinnost>code:9_ALO</cinnost>\n" +
                "            </faktura-vydana-polozka>\n" +
                "        </polozkyFaktury>\n" +
                "        <cisObj>123456789</cisObj>" +
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
                        .items(new IssuedInvoiceItems(
                                IssuedInvoiceItem.builder()
                                        .name("Bla bla jizdne")
                                        .amount(ONE)
                                        .sumVat(BigDecimal.valueOf(1500))
                                        .unitPrice(BigDecimal.valueOf(7500))
                                        .sumTotal(BigDecimal.valueOf(9000))
                                        .vatRate(BigDecimal.valueOf(21)).build()
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
                "        <polozkyFaktury removeAll=\"false\">\n" +
                "            <faktura-vydana-polozka>\n" +
                "                <nazev>Bla bla jizdne</nazev>\n" +
                "                <mnozBaleni>1</mnozBaleni>\n" +
                "                <szbDph>21</szbDph>\n" +
                "                <sumDph>1500</sumDph>\n" +
                "                <sumCelkem>9000</sumCelkem>\n" +
                "                <cenaMj>7500</cenaMj>\n" +
                "            </faktura-vydana-polozka>\n" +
                "        </polozkyFaktury>\n" +
                "    </faktura-vydana>\n" +
                "</winstrom>";
        assertThat(result.toString()).isXmlEqualTo(xml);
    }

    @Test
    public void invoiceWithDeposits() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "     <faktura-vydana>\n" +
                "          <odpocty-zaloh class=\"java.util.Collections$SingletonList\">\n" +
                "               <odpocet>\n" +
                "                    <id>ext:deposit</id>\n" +
                "                    <castkaMen>100</castkaMen>\n" +
                "                    <doklad>41</doklad>\n" +
                "               </odpocet>\n" +
                "          </odpocty-zaloh>\n" +
                "     </faktura-vydana>\n" +
                "</winstrom>\n";

        WinstromRequest envelope = WinstromRequest.builder()
                .issuedInvoice(
                        IssuedInvoice.builder()
                        .deposits(Collections.singletonList(
                                Deposit.builder()
                                        .id("ext:deposit")
                                        .amount(BigDecimal.valueOf(100))
                                        .deposit("41").build()
                        ))
                        .build()
                ).build();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(envelope, result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }

    @Test
    public void paymentStatusIsParsedCorrectly() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "    <faktura-vydana>\n" +
                "        <stavUhrK>stavUhr.uhrazenoRucne</stavUhrK>\n" +
                "    </faktura-vydana>\n" +
                "</winstrom>\n";

        WinstromRequest envelope = WinstromRequest.builder()
                .issuedInvoice(
                        IssuedInvoice.builder()
                                .paymentStatus(PaymentStatus.MANUALLY)
                                .build()
                ).build();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(envelope, result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }
}
