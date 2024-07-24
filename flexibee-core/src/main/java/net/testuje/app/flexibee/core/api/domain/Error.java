package net.testuje.app.flexibee.core.api.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(strict = false)
public class Error {

    @Attribute(name = "path", required = false)
    private String path;

    @Attribute(name = "code", required = false)
    private String code;

    @Attribute(name = "value", required = false)
    private String value;

    @Attribute(name = "ref", required = false)
    private String ref;

    @Text(required = false)
    private String msg;

}