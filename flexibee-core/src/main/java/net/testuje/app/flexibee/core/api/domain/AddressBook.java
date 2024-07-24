package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "adresar", strict = false)
public class AddressBook {

    @Attribute(name = "update", required = false)
    private Update update;

    @ElementList(entry = "id", type = String.class, inline = true, required =false)
    private List<String> id;

    @Element(name = "ic", required = false)
    private String regNo;

    @Element(name = "psc", required = false)
    private String postCode;

    @Element(name = "stat", required = false)
    private String country;

    @Element(name = "nazev", required = false)
    private String name;

    @Element(name = "mesto", required = false)
    private String city;

    @Element(name = "dic", required = false)
    private String vatId;

    @Element(name = "platceDph", required = false)
    private Boolean paysVat;

    @Element(name = "ulice", required = false)
    private String street;

    @Element(name = "kod", required = false)
    private String code;

}
