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
@Root(name = "odpocet")
public class Deposit {

    @Element(name = "id", required = false)
    private String id;

    @Element(name = "castkaMen")
    private BigDecimal amount;

    @Element(name = "doklad")
    private String deposit;

}
