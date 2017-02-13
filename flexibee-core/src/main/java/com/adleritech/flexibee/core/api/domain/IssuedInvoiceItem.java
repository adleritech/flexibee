package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "faktura-vydana-polozka")
public class IssuedInvoiceItem {

    @Element(name = "nazev")
    String name;

    @Element(name = "mnozBaleni")
    Integer amount;

    @Element(name = "szbDph")
    Double vatRate;

    @Element(name = "sumZkl")
    Double sumWithoutVat;

    @Element(name = "sumDph")
    Double sumVat;

    @Element(name = "cenaMj")
    Double unitPrice;

    @Element(name = "typCenyDphK")
    PriceKind priceKind;
    //
//    @Element(name="typSzbDphK")
//    Enum totalSum;
//
//    <nazev>Bla bla jizdne</nazev>
//    <mnozBaleni>1</mnozBaleni>
//    <szbDph>21.0</szbDph>
//    <typCenyDphK>typCeny.sDphKoef</typCenyDphK>
//    <typSzbDphK>typSzbDph.dphZakl</typSzbDphK>

}
