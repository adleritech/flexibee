package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "faktura-vydana")
public class IssuedInvoice {
    @ElementList(entry = "id", required = false, inline = true)
    private List<String> id;

    @Element(name = "kod", required = false)
    private String invoiceNumber;

    @Element(name = "typDokl", required = false)
    private String documentType;

    @Element(name = "stavUhrK", required = false)
    private PaymentStatus paymentStatus;

    @Element(name = "firma", required = false)
    private String company;

    @Element(name = "ic", required = false)
    private String regNo;

    @Element(name = "datVyst", required = false)
    private LocalDate issued;

    @Element(name = "datSplat", required = false)
    private LocalDate dueDate;

    @Element(name = "formaUhrK", required = false)
    private PaymentMethod paymentMethod;

    @Element(name = "duzpPuv", required = false)
    private LocalDate timeOfSupply;

    @Element(name = "datUcto", required = false)
    private LocalDate dateCharged;

    @Element(name = "bezPolozek", required = false)
    private Boolean noLines;

    @Element(name = "sumDphZakl", required = false)
    private BigDecimal sumWithoutVat;

    @Element(name = "zakazka", required = false)
    private String order;

    @Element(name = "formaUhradyCis", required = false)
    private String paymentForm;

    @Element(name = "polozkyFaktury", required = false)
    private IssuedInvoiceItems items;

    @ElementList(name="odpocty-zaloh", required = false)
    private List<Deposit> deposits;

    @Element(name="zavTxt", required = false)
    private String text;

    @Element(name="varSym", required = false)
    private String variableSymbol;

    @Element(name="cisObj", required = false)
    private String orderNumber;

    @Element(name="sumZklCelkem", required = false)
    private BigDecimal baseTotalSum;

    @Element(name="sumCelkZakl", required = false)
    private BigDecimal sumTotalWithoutVat;

    @Element(name="sumCelkem", required = false)
    private BigDecimal sumTotal;

    @Element(name="mena", required = false)
    private String currency;

    @Element(name="zaokrNaSumK", required = false)
    private RoundingPrecision roundingPrecision;

    @Element(name="primUcet", required = false)
    private String primaryAccount;

    @Element(name="protiUcet", required = false)
    private String contraAccount;

    @Element(name="dphZaklUcet", required = false)
    private String vatBaseAccount;

    @Element(name="stredisko", required = false)
    private String department;

    @Element(name="cinnost", required = false)
    private String businessSegment;

    @Element(name="clenKonVykDph", required = false)
    private String vatReportRow;

    @Element(name="zbyvaUhradit", required = false)
    private BigDecimal remainingToPay;

    @Element(name="rada", required = false)
    private String sequence;

    @Element(name="typUcOp", required = false)
    private String accountingTemplate;

    @Element(name="nazFirmy", required = false)
    private String companyName;

    @Element(name="popis", required = false)
    private String description;

    @Element(name="poznam", required = false)
    private String note;

    @Element(name = "sumOsv", required = false)
    private BigDecimal vatFreeSum;

}
