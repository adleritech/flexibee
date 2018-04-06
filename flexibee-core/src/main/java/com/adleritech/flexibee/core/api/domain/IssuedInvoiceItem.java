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
    @Element(name = "id", required = false)
    private String id;

    @Element(name = "nazev", required = false)
    private String name;

    @Element(name = "mnozBaleni", required = false)
    private BigDecimal amount;

    @Element(name = "mnozMj", required = false)
    private BigDecimal unitAmount;
    @Element(name = "szbDph", required = false)
    private BigDecimal vatRate;

    @Element(name = "sumZkl", required = false)
    private BigDecimal sumWithoutVat;

    @Element(name = "sumDph", required = false)
    private BigDecimal sumVat;

    @Element(name = "sumCelkem", required = false)
    private BigDecimal sumTotal;

    @Element(name = "cenaMj", required = false)
    private BigDecimal unitPrice;

    @Element(name = "typCenyDphK", required = false)
    private PriceKind priceKind;

    @Element(name="sumZklCelkem", required = false)
    private BigDecimal baseTotalSum;

    @Element(name = "typSzbDphK", required = false)
    private VatRateKind vatRateKind;

    @Element(name="typPolozkyK", required = false)
    private IssuedInvoiceItemType type;

}
