package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receivable {
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

    @Element(name = "datUcto", required = false)
    private LocalDate dateCharged;

    @Element(name = "datSplat", required = false)
    private LocalDate dueDate;

    @Element(name = "duzpUcto", required = false)
    private LocalDate taxableFulfillment;

    @Element(name="varSym", required = false)
    private String variableSymbol;

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

    @Element(name="sumOsvMen", required = false)
    private BigDecimal vatFreeSumCcy;

    @Element(name="sumCelkemMen", required = false)
    private BigDecimal totalSumCCy;

    @Element(name="mena", required = false)
    private String currency;

    @Element(name="typUcOp", required = false)
    private String accountingTemplate;

    @Element(name="primUcet", required = false)
    private String primaryAccount;

    @Element(name="protiUcet", required = false)
    private String contraAccount;

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

    @Element(name="poznam", required = false)
    private String note;

    @Element(name="rada", required = false)
    private String sequence;

    @Element(name="stredisko", required = false)
    private String department;

}
