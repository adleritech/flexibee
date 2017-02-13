package com.adleritech.flexibee.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssuedInvoice {

    @Element(name="typDokl")
    private String documentType;

    @Element(name="firma")
    private String company;

    @Element(name = "bezPolozek")
    private boolean withoutItems;

    @Element(name = "sumDphZakl")
    private double sumWithoutVat;

}
