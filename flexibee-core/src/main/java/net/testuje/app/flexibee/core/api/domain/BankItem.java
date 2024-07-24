package net.testuje.app.flexibee.core.api.domain;

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
@Root(name = "banka-polozka")
public class BankItem {

    @Element(name = "nazev", required = false)
    private String name;

    @Element(name = "szbDph", required = false)
    private BigDecimal vatRate;

    @Element(name = "sumZkl", required = false)
    private BigDecimal sumWithoutVat;

    @Element(name = "sumDph", required = false)
    private BigDecimal sumVat;

    @Element(name = "sumCelkem", required = false)
    private BigDecimal sumTotal;

    @Element(name = "typSzbDphK", required = false)
    private VatRateKind vatRateKind;

    @Element(name="mena", required = false)
    private String currency;

    @Element(name="doklInt", required = false)
    private String document;

    @Element(name="typPolozkyK", required = false)
    private ItemType itemType;

    @Element(name="cinnost", required = false)
    private String businessSegment;
}
