//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CreditCard](index.md)/[CreditCard](-credit-card.md)

# CreditCard

[JVM]\

public [CreditCard](index.md)[CreditCard](-credit-card.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [CreditCard.CardType](-card-type/index.md)cardType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)expiryDate, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)electronicCommerceIndicator, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)virtualCreditCardFlag, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)walletType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardAvsResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardCvvResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)cardAuthenticationFailureCount)

#### Parameters

JVM

| | |
|---|---|
| cardType | The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` |
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
