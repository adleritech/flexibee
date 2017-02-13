package com.adleritech.flexibee.api;

import com.adleritech.flexibee.api.domain.IssuedInvoice;
import com.adleritech.flexibee.api.domain.WinstromRequest;
import org.junit.Test;

public class FlexibeeClientTest {

    @Test
    public void createInvoice() throws Exception {
        WinstromRequest request = WinstromRequest.builder()
                .issuedInvoice(IssuedInvoice.builder()
                        .company("code:ABCFIRM1#")
                        .documentType("code:FAKTURA")
                        .withoutItems(true)
                        .sumWithoutVat(1000)
                        .build()).build();

        FlexibeeClient flexibeeClient = new FlexibeeClient("winstrom", "winstrom", "demo");
        flexibeeClient.createInvoice(request);

    }
}
