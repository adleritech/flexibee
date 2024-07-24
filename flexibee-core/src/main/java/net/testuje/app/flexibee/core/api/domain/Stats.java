package net.testuje.app.flexibee.core.api.domain;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Root(strict = false)
public class Stats {

    @Element(name = "created")
    private int created;

    @Element(name = "updated")
    private int updated;

    @Element(name = "deleted")
    private int deleted;

    @Element(name = "skipped")
    private int skipped;

    @Element(name = "failed")
    private int failed;
}
