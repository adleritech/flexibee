package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "winstrom")
public class AddressBookResponse {

    @Attribute(name = "version")
    private String version;

    @ElementList(name = "adresar", inline = true, required = false)
    private List<AddressBook> addressBook;

}
