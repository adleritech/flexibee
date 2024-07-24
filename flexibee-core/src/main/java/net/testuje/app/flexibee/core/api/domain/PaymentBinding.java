package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBinding {

    @Element(name = "uhrazovanaFak")
    private PaymentBindingInvoice paidInvoice;

    @Element(name = "zbytek")
    private PaymentBindingRemainderType bindingRemainderType;
    
}
