package net.testuje.app.flexibee.core.api.domain;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.Arrays;
import java.util.List;

@Data
public class IssuedInvoiceItems {
    public IssuedInvoiceItems() {
    }

    public IssuedInvoiceItems(IssuedInvoiceItem... items) {
        this(Arrays.asList(items), false);
    }

    public IssuedInvoiceItems(List<IssuedInvoiceItem> items, Boolean removeAllItems) {
        this.items = items;
        this.removeAllItems = removeAllItems;
    }

    @ElementList(inline = true)
    private List<IssuedInvoiceItem> items;

    @Attribute(name="removeAll", required = false)
    private Boolean removeAllItems;
}
