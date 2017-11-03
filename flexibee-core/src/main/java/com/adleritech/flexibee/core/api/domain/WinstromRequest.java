package com.adleritech.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Root(name = "winstrom")
@org.simpleframework.xml.Order(elements = {"adresar", "zakazka", "faktura-vydana"})
public class WinstromRequest extends Winstrom {

    @Element(name = "adresar", required = false)
    private AddressBook addressBook;

    @Element(name = "zakazka", required = false)
    private Order order;

    @Element(name = "faktura-vydana", required = false)
    private IssuedInvoice issuedInvoice;

    @Element(name = "interni-doklad", required = false)
    private InternalDocument internalDocument;

    public static WinstromRequestBuilder builder() {
        return new WinstromRequestBuilder();
    }

    public static class WinstromRequestBuilder {
        private AddressBook addressBook;
        private Order order;
        private IssuedInvoice issuedInvoice;
        private InternalDocument internalDocument;

        WinstromRequestBuilder() {
        }

        public WinstromRequestBuilder addressBook(AddressBook addressBook) {
            this.addressBook = addressBook;
            return this;
        }

        public WinstromRequestBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public WinstromRequestBuilder issuedInvoice(IssuedInvoice issuedInvoice) {
            this.issuedInvoice = issuedInvoice;
            return this;
        }

        public WinstromRequestBuilder internalDocument(InternalDocument internalDocument) {
            this.internalDocument = internalDocument;
            return this;
        }

        public WinstromRequest build() {
            return new WinstromRequest(addressBook, order, issuedInvoice, internalDocument);
        }

        public String toString() {
            return "WinstromRequest.WinstromRequestBuilder(addressBook=" + this.addressBook + ", order=" + this.order + ", issuedInvoice=" + this.issuedInvoice + ", internalDocument=" + this.internalDocument + ")";
        }
    }
}


