package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "faktura-vydana-polozka")
public class IssuedInvoiceItem {

    @Element(name = "nazev", required = false)
    String name;

    @Element(name = "mnozBaleni", required = false)
    BigDecimal amount;

    @Element(name = "szbDph", required = false)
    BigDecimal vatRate;

    @Element(name = "sumZkl", required = false)
    BigDecimal sumWithoutVat;

    @Element(name = "sumDph", required = false)
    BigDecimal sumVat;

    @Element(name = "sumCelkem", required = false)
    BigDecimal sumTotal;

    @Element(name = "cenaMj", required = false)
    BigDecimal unitPrice;

    @Element(name = "typCenyDphK", required = false)
    PriceKind priceKind;

    @Element(name = "typSzbDphK", required = false)
    VatRateKind vatRateKind;

}
