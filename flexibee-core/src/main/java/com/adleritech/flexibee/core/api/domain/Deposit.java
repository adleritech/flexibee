package com.adleritech.flexibee.core.api.domain;

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
@Root(name = "odpocet")
public class Deposit {

    @Element(name = "castkaMen")
    private BigDecimal amount;

    @Element(name = "doklad")
    private String deposit;

}
