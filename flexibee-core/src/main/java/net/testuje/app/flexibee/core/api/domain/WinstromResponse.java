package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "winstrom", strict = false)
public class WinstromResponse extends Winstrom {

    @Element(name = "success")
    private boolean success;

    @Element(name = "stats")
    private Stats stats;

    @ElementList(name = "results", required = false)
    private List<Result> results;

}
