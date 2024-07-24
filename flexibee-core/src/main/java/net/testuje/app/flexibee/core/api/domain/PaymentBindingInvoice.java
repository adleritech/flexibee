package net.testuje.app.flexibee.core.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBindingInvoice {
    
    @Attribute(name = "type")
    private PaymentBindingInvoiceType type;

    @Attribute(name = "castka")
    private BigDecimal amount;
    
    @Text
    private String issuedInvoiceId;

}
