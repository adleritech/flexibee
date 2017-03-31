package com.adleritech.flexibee.core.api.domain;

import com.adleritech.flexibee.core.api.transformers.Factory;
import org.junit.Test;
import org.simpleframework.xml.Serializer;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBookTest {

    @Test
    public void createAddressBookForCSOB() throws Exception {
        AddressBook address = AddressBook.builder()
                .name("Československá obchodní banka, a. s.")
                .vatId("CZ00001350")
                .regNo("00001350")
                .city("Praha 5")
                .street("Radlická 333/150")
                .postCode("15057")
                .paysVat(true)
                .country(Country.cz.code)
                .build();

        String xml = "<adresar>\n" +
                "    <ic>00001350</ic>\n" +
                "    <psc>15057</psc>\n" +
                "    <stat>code:CZ</stat>\n" +
                "    <nazev>Československá obchodní banka, a. s.</nazev>\n" +
                "    <mesto>Praha 5</mesto>\n" +
                "    <dic>CZ00001350</dic>\n" +
                "    <platceDph>true</platceDph>\n" +
                "    <ulice>Radlická 333/150</ulice>\n" +
                "</adresar>";

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(address, result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }

}
