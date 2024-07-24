package net.testuje.app.flexibee.core.api.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.Arrays;
import java.util.List;

public class ObligationItems {

    public ObligationItems() {
    }

    public ObligationItems(ObligationItem... items) {
        this(Arrays.asList(items), false);
    }

    public ObligationItems(List<ObligationItem> items, Boolean removeAllItems) {
        this.items = items;
        this.removeAllItems = removeAllItems;
    }

    @ElementList(inline = true)
    private List<ObligationItem> items;

    @Attribute(name = "removeAll", required = false)
    private Boolean removeAllItems;

    public List<ObligationItem> getItems() {
        return items;
    }
}
