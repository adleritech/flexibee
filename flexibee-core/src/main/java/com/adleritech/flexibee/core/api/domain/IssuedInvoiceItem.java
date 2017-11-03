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

    @Element(name = "nazev")
    String name;

    @Element(name = "mnozBaleni")
    Integer amount;

    @Element(name = "szbDph")
    BigDecimal vatRate;

    @Element(name = "sumZkl", required = false)
    BigDecimal sumWithoutVat;

    @Element(name = "sumDph", required = false)
    BigDecimal sumVat;

    @Element(name = "sumCelkem", required = false)
    BigDecimal sumTotal;

    @Element(name = "cenaMj")
    BigDecimal unitPrice;

    @Element(name = "typCenyDphK", required = false)
    PriceKind priceKind;

}
