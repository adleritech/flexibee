package net.testuje.app.flexibee.core.api.domain;

import net.testuje.app.flexibee.core.api.transformers.Factory;
import org.junit.Test;
import org.simpleframework.xml.Serializer;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {

    @Test
    public void createBankWithInvoicePaymentBinding() throws Exception {
        Bank bank = Bank.builder()
                .id(Collections.singletonList("123"))
                .paymentBinding(
                        PaymentBinding.builder()
                                .paidInvoice(
                                        PaymentBindingInvoice.builder()
                                                .type(PaymentBindingInvoiceType.ISSUED_INVOICE)
                                                .amount(BigDecimal.valueOf(42.55))
                                                .issuedInvoiceId("flexibee-id")
                                                .build()
                                )
                                .bindingRemainderType(PaymentBindingRemainderType.PROHIBITED)
                                .build()
                )
                .build();

        String xml = "<banka>\n" +
                "   <id>123</id>\n" +
                "   <polozkyIntDokladu/>\n" +
                "   <sparovani>\n" +
                "      <uhrazovanaFak type=\"faktura-vydana\" castka=\"42.55\">flexibee-id</uhrazovanaFak>\n" +
                "      <zbytek>ne</zbytek>\n" +
                "   </sparovani>\n" +
                "</banka>";
        
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(bank, result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }
    
}
