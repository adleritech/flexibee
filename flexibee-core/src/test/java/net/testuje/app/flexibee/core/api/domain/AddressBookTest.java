package net.testuje.app.flexibee.core.api.domain;

import net.testuje.app.flexibee.core.api.transformers.Factory;
import org.junit.Test;
import org.simpleframework.xml.Serializer;

import java.io.ByteArrayOutputStream;
import java.util.Collections;

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

    @Test
    public void createAddressBookForCSOB2() throws Exception {
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

        String xml = "<winstrom version=\"1.0\">\n" +
                "<adresar>\n" +
                "    <ic>00001350</ic>\n" +
                "    <psc>15057</psc>\n" +
                "    <stat>code:CZ</stat>\n" +
                "    <nazev>Československá obchodní banka, a. s.</nazev>\n" +
                "    <mesto>Praha 5</mesto>\n" +
                "    <dic>CZ00001350</dic>\n" +
                "    <platceDph>true</platceDph>\n" +
                "    <ulice>Radlická 333/150</ulice>\n" +
                "</adresar>" +
                "</winstrom>\n";

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Serializer serializer = Factory.persister();
        serializer.write(AddressBookResponse
                .builder().version("1.0")
                .addressBook(Collections.singletonList(address)).build(), result);

        assertThat(result.toString()).isXmlEqualTo(xml);
    }

    @Test
    public void parseXmlIntoAddressBook() throws Exception {
        String responseBody = "<winstrom version=\"1.0\">\n" +
                "  <adresar>\n" +
                "    <id>1344</id>\n" +
                "    <lastUpdate>2017-03-06T12:14:11.996+01:00</lastUpdate>\n" +
                "    <kod>AUERAUER</kod>\n" +
                "    <nazev>Auer-Auer</nazev>\n" +
                "    <nazevA></nazevA>\n" +
                "    <nazevB></nazevB>\n" +
                "    <nazevC></nazevC>\n" +
                "    <poznam></poznam>\n" +
                "    <popis></popis>\n" +
                "    <platiOd>0</platiOd>\n" +
                "    <platiDo>9999</platiDo>\n" +
                "    <ulice>82252 Josue Manors</ulice>\n" +
                "    <mesto>Port Thaliahaven</mesto>\n" +
                "    <psc>32885</psc>\n" +
                "    <tel></tel>\n" +
                "    <mobil></mobil>\n" +
                "    <fax></fax>\n" +
                "    <email></email>\n" +
                "    <www></www>\n" +
                "    <stat showAs=\"Česká republika\" ref=\"/c/demo/stat/39.xml\">code:CZ</stat>\n" +
                "    <eanKod></eanKod>\n" +
                "    <ic>329529</ic>\n" +
                "    <dic></dic>\n" +
                "    <vatId></vatId>\n" +
                "    <postovniShodna>true</postovniShodna>\n" +
                "    <faEanKod></faEanKod>\n" +
                "    <faJmenoFirmy></faJmenoFirmy>\n" +
                "    <faUlice></faUlice>\n" +
                "    <faMesto></faMesto>\n" +
                "    <faPsc></faPsc>\n" +
                "    <splatDny></splatDny>\n" +
                "    <limitFak>0.0</limitFak>\n" +
                "    <limitPoSplatDny></limitPoSplatDny>\n" +
                "    <limitPoSplatZakaz>false</limitPoSplatZakaz>\n" +
                "    <platceDph>false</platceDph>\n" +
                "    <formExportK></formExportK>\n" +
                "    <typVztahuK showAs=\"Odběr./Dodav.\">typVztahu.odberDodav</typVztahuK>\n" +
                "    <kodPojistovny></kodPojistovny>\n" +
                "    <nazevPojistovny></nazevPojistovny>\n" +
                "    <osloveni></osloveni>\n" +
                "    <slevaDokl>0.0</slevaDokl>\n" +
                "    <obpAutomHotovo>false</obpAutomHotovo>\n" +
                "    <nazev2></nazev2>\n" +
                "    <nazev2A></nazev2A>\n" +
                "    <nazev2B></nazev2B>\n" +
                "    <nazev2C></nazev2C>\n" +
                "    <nespolehlivyPlatce>false</nespolehlivyPlatce>\n" +
                "    <revize>0</revize>\n" +
                "    <stitky></stitky>\n" +
                "    <pocetPriloh>0</pocetPriloh>\n" +
                "    <katastrUzemi></katastrUzemi>\n" +
                "    <parcela></parcela>\n" +
                "    <datNaroz></datNaroz>\n" +
                "    <rodCis></rodCis>\n" +
                "    <datZaloz></datZaloz>\n" +
                "    <canceled>false</canceled>\n" +
                "    <skupFir></skupFir>\n" +
                "    <stredisko></stredisko>\n" +
                "    <faStat></faStat>\n" +
                "    <zodpOsoba></zodpOsoba>\n" +
                "    <skupCen></skupCen>\n" +
                "    <formaUhradyCis></formaUhradyCis>\n" +
                "    <kontakty></kontakty>\n" +
                "    <mistaUrceni></mistaUrceni>\n" +
                "  </adresar>\n" +
                "</winstrom>\n";

        Serializer serializer = Factory.persister();
        AddressBookResponse addressBook = serializer.read(AddressBookResponse.class, responseBody);

        assertThat(addressBook.getAddressBook().get(0).getRegNo()).isEqualTo("329529");
    }

    @Test
    public void winstromWithoutAddressBookIsValid() throws Exception {
        String responseBody = "<winstrom version=\"1.0\">\n" +
                "</winstrom>\n";

        Serializer serializer = Factory.persister();
        AddressBookResponse addressBook = serializer.read(AddressBookResponse.class, responseBody);
        assertThat(addressBook.getAddressBook()).isNull();
    }

    @Test
    public void winstromMightHaveMultipleAddressBooks() throws Exception {
        String responseBody = "<winstrom version=\"1.0\">\n" +
                "<adresar><nazev>test</nazev></adresar>" +
                "<adresar><nazev>test</nazev></adresar>" +
                "</winstrom>\n";

        Serializer serializer = Factory.persister();
        AddressBookResponse addressBook = serializer.read(AddressBookResponse.class, responseBody);
        assertThat(addressBook.getAddressBook()).hasSize(2);
    }

}
