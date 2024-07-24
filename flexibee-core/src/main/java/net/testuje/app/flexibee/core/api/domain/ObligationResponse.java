package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "winstrom")
public class ObligationResponse {

    @Attribute(name = "version")
    private String version;

    @Element(name = "zavazek")
    private Obligation obligation;

}
