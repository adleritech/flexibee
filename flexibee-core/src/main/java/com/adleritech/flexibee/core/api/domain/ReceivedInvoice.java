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
public class ReceivedInvoice {

    @ElementList(required = false, inline = true, entry = "id")
    private List<String> ids;

    @Element(name = "typDokl", required = false)
    private String documentType;

    @Element(name = "popis", required = false)
    private String description;

    @Element(name = "firma", required = false)
    private String company;

    @Element(name = "datVyst", required = false)
    private LocalDate issued;

    @Element(name = "datSplat", required = false)
    private LocalDate dueDate;

    @Element(name = "duzpPuv", required = false)
    private LocalDate timeOfSupply;

    @Element(name = "bezPolozek", required = false)
    private Boolean withoutItems;

    @Element(name = "sumCelkZakl", required = false)
    private BigDecimal baseTotalSum;

    @Element(name = "sumOsv", required = false)
    private BigDecimal vatFreeSum;

    @Element(name = "sumOsvMen", required = false)
    private BigDecimal vatFreeSumCcy;

    @Element(name = "mena", required = false)
    private String currency;

    @Element(name = "stredisko", required = false)
    private String department;

    @Element(name = "zakazka", required = false)
    private String order;

    @Element(name = "cisDosle", required = false)
    private String incomingNumber;

    @Element(name = "varSym", required = false)
    private String variableSymbol;

    @Element(name = "primUcet", required = false)
    private String primaryAccount;

    @Element(name = "protiUcet", required = false)
    private String contraAccount;

    @Element(name = "bankovniUcet", required = false)
    private String bankAccount;
}
