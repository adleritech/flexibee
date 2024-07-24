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
@Root(name = "zavazek")
public class Obligation {
    @ElementList(required = false, inline = true, entry = "id")
    private List<String> id;

    @Element(name = "typDokl", required = false)
    private String documentType;

    @Element(name = "firma", required = false)
    private String company;

    @Element(name = "datVyst", required = false)
    private LocalDate issued;

    @Element(name = "duzpPuv", required = false)
    private LocalDate timeOfSupply;

    @Element(name = "duzpUcto", required = false)
    private LocalDate taxableFulfillment;

    @Element(name = "datUcto", required = false)
    private LocalDate dateCharged;

    @Element(name = "datSplat", required = false)
    private LocalDate dueDate;

    @Element(name="varSym", required = false)
    private String variableSymbol;

    @Element(name="specSym", required = false)
    private String specificSymbol;

    @Element(name="cisDosle", required = false)
    private String incomingNumber;

    @Element(name="popis", required = false)
    private String description;

    @Element(name="sumZklCelkem", required = false)
    private BigDecimal baseTotalSum;

    @Element(name="sumOsv", required = false)
    private BigDecimal vatFreeSum;

    @Element(name="sumCelkem", required = false)
    private BigDecimal totalSum;

    @Element(name="sumZklCelkemMen", required = false)
    private BigDecimal baseTotalSumCcy;

    @Element(name="sumOsvMen", required = false)
    private BigDecimal vatFreeSumCcy;

    @Element(name="sumCelkemMen", required = false)
    private BigDecimal totalSumCcy;

    @Element(name="mena", required = false)
    private String currency;

    @Element(name="primUcet", required = false)
    private String primaryAccount;

    @Element(name="protiUcet", required = false)
    private String contraAccount;

    @Element(name="typUcOp", required = false)
    private String accountingTemplate;

    @Element(name="zakazka", required = false)
    private String order;

    @Element(name="clenDph", required = false)
    private String vatRow;

    @Element(name="clenKonVykDph", required = false)
    private String vatReportRow;

    @Element(name="bezPolozek", required = false)
    private Boolean noLines;

    @Element(name="bankovniUcet", required = false)
    private String bankAccount;

    @Element(name="banSpojDod", required = false)
    private String supplierBankAccount;

    @Element(name="buc", required = false)
    private String buc;

    @Element(name="smerKod", required = false)
    private String smerKod;

    @Element(name="iban", required = false)
    private String iban;

    @Element(name="bic", required = false)
    private String bic;

    @Element(name="poznam", required = false)
    private String note;

    @Element(name="rada", required = false)
    private String sequence;

    @Element(name="stredisko", required = false)
    private String department;

    @Element(name="cinnost", required = false)
    private String businessSegment;

    @Element(name="zakazPlatba", required = false)
    private Boolean paymentForbidden;

    @Element(name = "polozkyFaktury", required = false)
    private ObligationItems items;

}
