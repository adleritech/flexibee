package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "banka")
public class Bank {
    @ElementList(required = false, inline = true, entry = "id")
    private List<String> id;

    @Element(name = "kod", required = false)
    private String code;

    @Element(name = "typDokl", required = false)
    private String documentType;

    @Element(name = "firma", required = false)
    private String company;

    @Element(name = "datVyst", required = false)
    private LocalDate issued;

    @Element(name = "duzpPuv", required = false)
    private LocalDate timeOfSupply;

    @Element(name="varSym", required = false)
    private String variableSymbol;

    @Element(name="cisDosle", required = false)
    private String incomingNumber;

    @Element(name="popis", required = false)
    private String description;

    @Element(name="sumZklCelkem", required = false)
    private BigDecimal baseTotalSum;

    @Element(name="sumCelkemMen", required = false)
    private BigDecimal totalSumCcy;

    @Element(name="sumOsv", required = false)
    private BigDecimal vatFreeSum;

    @Element(name="sumOsvMen", required = false)
    private BigDecimal vatFreeSumCcy;

    @Element(name="sumCelkem", required = false)
    private BigDecimal totalSum;

    @Element(name="mena", required = false)
    private String currency;

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

    @Element(name="banka", required = false)
    private String bank;

    @Element(name="stredisko", required = false)
    private String department;

    @Element(name="cinnost", required = false)
    private String businessSegment;

    @Element(name="typPohybuK", required = false)
    private AccountMovementType accountMovementType;

    @Path("polozkyIntDokladu")
    @ElementList(required = false, inline = true)
    private List<BankItem> items;

    @Element(name="rada", required = false)
    private String sequence;

    @Element(name="typUcOp", required = false)
    private String accountingTemplate;

    @Element(name="cisSouhrnne", required = false)
    private String accountStatementName;

    @Element(name="poznam", required = false)
    private String note;

    @Element(name = "buc", required = false)
    private String buc;

    @Element(name = "smerKod", required = false)
    private String smerKod;

    @Element(name = "sparovani", required = false)
    private PaymentBinding paymentBinding; 
    
}
