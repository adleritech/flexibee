package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "faktura-vydana-polozka")
public class IssuedInvoiceItem {
    @ElementList(entry = "id", required = false, inline = true)
    private List<String> id;

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

    @Element(name="stredisko", required = false)
    private String department;

    @Element(name = "kopStred", required = false)
    private Boolean copyDepartment;

    @Element(name="cinnost", required = false)
    private String businessSegment;

    @Element(name = "kopCinnost", required = false)
    private Boolean copyBusinessSegment; 

    @Element(name="clenKonVykDph", required = false)
    private String vatReportRow;

    @Element(name="zbyvaUhradit", required = false)
    private BigDecimal remainingToPay;

    @Element(name="zklMdUcet", required = false)
    private String debitSideBase;

    @Element(name="zklDalUcet", required = false)
    private String creditSideBase;

    @Element(name="dphMdUcet", required = false)
    private String creditSideVat;

    @Element(name="dphDalUcet", required = false)
    private String debitSideVat;

    @Element(name="typUcOp", required = false)
    private String accountingEntry;

    @Element(name="kopTypUcOp", required = false)
    private Boolean copyAccountingEntry;

}
