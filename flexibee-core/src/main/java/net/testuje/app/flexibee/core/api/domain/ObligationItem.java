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
@Root(name = "zavazek-polozka")
public class ObligationItem {

    @Element(name = "nazev", required = false)
    private String name;

    @Element(name = "kopZklMdUcet", required = false)
    private Boolean debitSideCopy;

    @Element(name = "kopZklDalUcet", required = false)
    private Boolean creditSideCopy;

    @Element(name = "zklMdUcet", required = false)
    private String debitSide;

    @Element(name = "zklDalUcet", required = false)
    private String creditSide;

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

    @Element(name = "mena", required = false)
    private String currency;

    @Element(name = "typPolozkyK", required = false)
    private ItemType itemType;

    @Element(name = "doklFak", required = false)
    private String relDoc;

    @Element(name="clenKonVykDph", required = false)
    private String vatReportRow;

    @Element(name = "kopClenDph", required = false)
    private Boolean vatRowCopy;

    @Element(name="clenDph", required = false)
    private String vatRow;

    @Element(name="cinnost", required = false)
    private String businessSegment;

}
