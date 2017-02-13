package com.adleritech.flexibee.core.api;

import com.adleritech.flexibee.core.api.domain.IssuedInvoice;
import com.adleritech.flexibee.core.api.domain.IssuedInvoiceItem;
import com.adleritech.flexibee.core.api.domain.WinstromRequest;
import com.adleritech.flexibee.core.api.domain.WinstromResponse;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlexibeeClientTest {

    @Test
    public void createInvoice() throws Exception {
        WinstromRequest request = WinstromRequest.builder()
                .issuedInvoice(IssuedInvoice.builder()
                        .company("code:ABCFIRM1#")
                        .documentType("code:FAKTURA")
                        .withoutItems(true)
                        .sumWithoutVat(1000d)
                        .build()).build();

        FlexibeeClient flexibeeClient = new FlexibeeClient("winstrom", "winstrom", "demo");
        WinstromResponse response = flexibeeClient.createInvoice(request);
        assertThat(response.getResults().getResult().getId()).isNotEmpty();
        Assertions.assertThat(response.getResults().getResult().getId()).isNotEmpty();
        assertThat(response.isSuccess()).isTrue();
    }


    @Test
    public void createDummyInvoice() throws Exception {
        WinstromRequest request = WinstromRequest.builder()
                .issuedInvoice(IssuedInvoice.builder()
                        .company("code:ABCFIRM1#")
                        .documentType("code:FAKTURA")
                        .items(Arrays.asList(
                                IssuedInvoiceItem.builder()
                                        .name("Bla bla jizdne")
                                        .amount(1)
                                        .sumVat(1500d)
                                        .unitPrice(9000d)
                                        .sumWithoutVat(7500d)
                                        .vatRate(21d).build()
                        ))
                        .build()).build();

        FlexibeeClient flexibeeClient = new FlexibeeClient("winstrom", "winstrom", "demo");
        WinstromResponse response = flexibeeClient.createInvoice(request);
        assertThat(response.getResults().getResult().getId()).isNotEmpty();
        assertThat(response.isSuccess()).isTrue();
    }
}
