# Flexibee

[![CircleCI](https://circleci.com/gh/adleritech/flexibee.svg?style=shield)](https://circleci.com/gh/adleritech/flexibee)

It's unofficial Java library for [Flexibee.eu](https://www.flexibee.eu) . The library offers set of Flexibee API objects for creating invoices via its REST API.

## Usage

### Maven

```xml
<dependency>
    <groupId>com.adleritech</groupId>
    <artifactId>flexibee</artifactId>
    <version>...</version>
</dependency>
```


### Gradle
```
compile "com.adleritech:flexibee:..."
```

To create an invoice and sent it to flexibee you can use the following code snipped:
```java
WinstromRequest request = WinstromRequest.builder()
        .issuedInvoice(IssuedInvoice.builder()
                .company("code:ABCFIRM1#")
                .documentType(DocumentType.invoice)
                .items(Arrays.asList(
                        IssuedInvoiceItem.builder()
                                .name("Invoice line")
                                .amount(1)
                                .unitPrice(128_140.96)
                                .vatRate(21d).build()
                ))
                .build()).build();

FlexibeeClient flexibeeClient = new FlexibeeClient("winstrom", "winstrom", "demo");
WinstromResponse response = flexibeeClient.createInvoice(request);
```

For more examples please check test.
