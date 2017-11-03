package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssuedInvoice {

    @Element(name = "typDokl", required = false)
    private String documentType;

    @Element(name = "stavUhrK", required = false)
    private PaymentStatus paymentStatus;

    @Element(name = "firma", required = false)
    private String company;

    @Element(name = "datVyst", required = false)
    private LocalDate issued;

    @Element(name = "datSplat", required = false)
    private LocalDate dueDate;

    @Element(name = "formaUhrK", required = false)
    private PaymentMethod paymentMethod;

    @Element(name = "duzpPuv", required = false)
    private LocalDate timeOfSupply;

    @Element(name = "bezPolozek", required = false)
    private Boolean withoutItems;

    @Element(name = "sumDphZakl", required = false)
    private Double sumWithoutVat;

    @Element(name = "zakazka", required = false)
    private String order;

    @ElementList(name = "polozkyFaktury", required = false)
    private List<IssuedInvoiceItem> items;

    @ElementList(name="odpocty-zaloh", required = false)
    private List<Deposit> deposits;

    @Element(name="zavTxt", required = false)
    private String text;

    @Element(name="varSym", required = false)
    private String variableSymbol;

}
