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
public class ReceivableResponse {

    @Attribute(name = "version")
    private String version;

    @Element(name = "pohledavka")
    private Receivable receivable;

}
