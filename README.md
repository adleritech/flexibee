# Flexibee [![CircleCI](https://circleci.com/gh/adleritech/flexibee.svg?style=shield)](https://circleci.com/gh/adleritech/flexibee) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.adleritech/flexibee-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.adleritech/flexibee-core)

It's unofficial Java library for [Flexibee.eu](https://www.flexibee.eu). The library offers a set of Flexibee API objects for creating invoices via its REST API.

## Usage

### Maven

```xml
<dependency>
    <groupId>com.adleritech</groupId>
    <artifactId>flexibee</artifactId>
    <version>0.0.12</version>
</dependency>
```


### Gradle
```
compile "com.adleritech:flexibee:0.0.12"
```

To create an invoice and send it to Flexibee, you can use the following code snipped:
```java
WinstromRequest request = WinstromRequest.builder()
        .issuedInvoice(IssuedInvoice.builder()
                .company("code:ABCFIRM1#")
                .documentType("code:FAKTURA")
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

For more examples please check tests.

## Dev
 
### Troubleshooting 

Before package release you might have to run `export GPG_TTY=$(tty)`.
