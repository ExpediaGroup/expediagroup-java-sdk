//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CreditCardAllOf](index.md)

# CreditCardAllOf

public final class [CreditCardAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| cardType | The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` |
| cardNumber | All the digits (unencrypted) of the credit card number associated with the payment. |
| expiryDate | Expiration date of the credit card used for payment, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| telephones | Telephone(s) associated with card holder and credit card. |
| electronicCommerceIndicator | Electronic Commerce Indicator, a two or three digit number usually returned by a 3rd party payment processor in regards to the authentication used when gathering the cardholder's payment credentials. |
| virtualCreditCardFlag | A flag to indicate that the bank card being used for the charge is a virtual credit card. |
| walletType | If a virtual/digital form of payment was used, the type of digital wallet should be specified here. Possible `wallet_type`'s include: `Google` or `ApplePay`. |
| cardAvsResponse | A field used to confirm if the address provided at the time of purchase matches what the bank has on file for the Credit Card. |
| cardCvvResponse | A field used to confirm the Card Verification Value on the Credit Card matches the Credit Card used at the time of purchase. |
| merchantOrderCode | Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. |
| cardAuthenticationFailureCount | Total authentication failure count for given card. |

## Constructors

| | |
|---|---|
| [CreditCardAllOf](-credit-card-all-of.md) | [JVM]<br>public [CreditCardAllOf](index.md)[CreditCardAllOf](-credit-card-all-of.md)([CreditCardAllOf.CardType](-card-type/index.md)cardType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)expiryDate, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)electronicCommerceIndicator, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)virtualCreditCardFlag, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)walletType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardAvsResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardCvvResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)cardAuthenticationFailureCount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [CardType](-card-type/index.md) | [JVM]<br>public enum [CardType](-card-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[CreditCardAllOf.CardType](-card-type/index.md)&gt;<br>The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` Values: AMERICAN_EXPRESS,DINERS_CLUB,DISCOVER,JCB,MASTER_CARD,SOLO,SWITCH,MAESTRO,CHINA_UNION_PAY,UATP,VISA |

## Properties

| Name | Summary |
|---|---|
| [cardAuthenticationFailureCount](index.md#426420627%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[cardAuthenticationFailureCount](index.md#426420627%2FProperties%2F-173342751) |
| [cardAvsResponse](index.md#-1444357045%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardAvsResponse](index.md#-1444357045%2FProperties%2F-173342751) |
| [cardCvvResponse](index.md#1237752166%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 20)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardCvvResponse](index.md#1237752166%2FProperties%2F-173342751) |
| [cardNumber](index.md#868213639%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardNumber](index.md#868213639%2FProperties%2F-173342751) |
| [cardType](index.md#73658742%2FProperties%2F-173342751) | [JVM]<br>private final [CreditCardAllOf.CardType](-card-type/index.md)[cardType](index.md#73658742%2FProperties%2F-173342751) |
| [electronicCommerceIndicator](index.md#1616397986%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[electronicCommerceIndicator](index.md#1616397986%2FProperties%2F-173342751) |
| [expiryDate](index.md#-719928449%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[expiryDate](index.md#-719928449%2FProperties%2F-173342751) |
| [merchantOrderCode](index.md#279750695%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantOrderCode](index.md#279750695%2FProperties%2F-173342751) |
| [telephones](index.md#-298787375%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#-298787375%2FProperties%2F-173342751) |
| [virtualCreditCardFlag](index.md#-1372938470%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[virtualCreditCardFlag](index.md#-1372938470%2FProperties%2F-173342751) |
| [walletType](index.md#1674354797%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[walletType](index.md#1674354797%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CreditCardAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getCardAuthenticationFailureCount](get-card-authentication-failure-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCardAuthenticationFailureCount](get-card-authentication-failure-count.md)() |
| [getCardAvsResponse](get-card-avs-response.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardAvsResponse](get-card-avs-response.md)() |
| [getCardCvvResponse](get-card-cvv-response.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardCvvResponse](get-card-cvv-response.md)() |
| [getCardNumber](get-card-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardNumber](get-card-number.md)() |
| [getCardType](get-card-type.md) | [JVM]<br>public final [CreditCardAllOf.CardType](-card-type/index.md)[getCardType](get-card-type.md)() |
| [getElectronicCommerceIndicator](get-electronic-commerce-indicator.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getElectronicCommerceIndicator](get-electronic-commerce-indicator.md)() |
| [getExpiryDate](get-expiry-date.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getExpiryDate](get-expiry-date.md)() |
| [getMerchantOrderCode](get-merchant-order-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantOrderCode](get-merchant-order-code.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getVirtualCreditCardFlag](get-virtual-credit-card-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getVirtualCreditCardFlag](get-virtual-credit-card-flag.md)() |
| [getWalletType](get-wallet-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getWalletType](get-wallet-type.md)() |
