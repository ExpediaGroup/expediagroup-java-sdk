//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[CreditCard](index.md)

# CreditCard

public final class [CreditCard](index.md) implements [Payment](../-payment/index.md)

#### Parameters

JVM

| | |
|---|---|
| cardType | The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` |
| cardNumber | All the digits (unencrypted) of the credit card number associated with the payment. |
| expiryDate | Expiration date of the credit card used for payment, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
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
| [CreditCard](-credit-card.md) | [JVM]<br>public [CreditCard](index.md)[CreditCard](-credit-card.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [CreditCard.CardType](-card-type/index.md)cardType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)expiryDate, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)electronicCommerceIndicator, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)virtualCreditCardFlag, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)walletType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardAvsResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardCvvResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)cardAuthenticationFailureCount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [CardType](-card-type/index.md) | [JVM]<br>public enum [CardType](-card-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[CreditCard.CardType](-card-type/index.md)&gt;<br>The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` Values: AMERICAN_EXPRESS,DINERS_CLUB,DISCOVER,JCB,MASTER_CARD,SOLO,SWITCH,MAESTRO,CHINA_UNION_PAY,VISA |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CreditCard.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public [Payment.Brand](../-payment/-brand/index.md)[getBrand](get-brand.md)() |
| [getCardAuthenticationFailureCount](get-card-authentication-failure-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCardAuthenticationFailureCount](get-card-authentication-failure-count.md)() |
| [getCardAvsResponse](get-card-avs-response.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardAvsResponse](get-card-avs-response.md)() |
| [getCardCvvResponse](get-card-cvv-response.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardCvvResponse](get-card-cvv-response.md)() |
| [getCardNumber](get-card-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardNumber](get-card-number.md)() |
| [getCardType](get-card-type.md) | [JVM]<br>public final [CreditCard.CardType](-card-type/index.md)[getCardType](get-card-type.md)() |
| [getElectronicCommerceIndicator](get-electronic-commerce-indicator.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getElectronicCommerceIndicator](get-electronic-commerce-indicator.md)() |
| [getExpiryDate](get-expiry-date.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getExpiryDate](get-expiry-date.md)() |
| [getMerchantOrderCode](get-merchant-order-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantOrderCode](get-merchant-order-code.md)() |
| [getMethod](get-method.md) | [JVM]<br>public [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getReason](get-reason.md) | [JVM]<br>public [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |
| [getVirtualCreditCardFlag](get-virtual-credit-card-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getVirtualCreditCardFlag](get-virtual-credit-card-flag.md)() |
| [getWalletType](get-wallet-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getWalletType](get-wallet-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [authorizedAmount](index.md#-458259365%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[authorizedAmount](index.md#-458259365%2FProperties%2F-1883119931) |
| [billingAddress](index.md#-2053161931%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentBillingAddress](../-payment-billing-address/index.md)[billingAddress](index.md#-2053161931%2FProperties%2F-1883119931) |
| [billingEmailAddress](index.md#-1755038823%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingEmailAddress](index.md#-1755038823%2FProperties%2F-1883119931) |
| [billingName](index.md#74848550%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[billingName](index.md#74848550%2FProperties%2F-1883119931) |
| [brand](index.md#-1555841115%2FProperties%2F-1883119931) | [JVM]<br>private final [Payment.Brand](../-payment/-brand/index.md)[brand](index.md#-1555841115%2FProperties%2F-1883119931) |
| [cardAuthenticationFailureCount](index.md#-984774079%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[cardAuthenticationFailureCount](index.md#-984774079%2FProperties%2F-1883119931) |
| [cardAvsResponse](index.md#448951645%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardAvsResponse](index.md#448951645%2FProperties%2F-1883119931) |
| [cardCvvResponse](index.md#-1163906440%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 20)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardCvvResponse](index.md#-1163906440%2FProperties%2F-1883119931) |
| [cardNumber](index.md#-578066635%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardNumber](index.md#-578066635%2FProperties%2F-1883119931) |
| [cardType](index.md#-2131195740%2FProperties%2F-1883119931) | [JVM]<br>private final [CreditCard.CardType](-card-type/index.md)[cardType](index.md#-2131195740%2FProperties%2F-1883119931) |
| [electronicCommerceIndicator](index.md#1741345972%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[electronicCommerceIndicator](index.md#1741345972%2FProperties%2F-1883119931) |
| [expiryDate](index.md#2128758573%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[expiryDate](index.md#2128758573%2FProperties%2F-1883119931) |
| [merchantOrderCode](index.md#-1316731719%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantOrderCode](index.md#-1316731719%2FProperties%2F-1883119931) |
| [method](index.md#-963452339%2FProperties%2F-1883119931) | [JVM]<br>private final [PaymentMethod](../-payment-method/index.md)[method](index.md#-963452339%2FProperties%2F-1883119931) |
| [operations](index.md#2062204194%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Operations](../-operations/index.md)[operations](index.md#2062204194%2FProperties%2F-1883119931) |
| [reason](index.md#-1985386934%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentReason](../-payment-reason/index.md)[reason](index.md#-1985386934%2FProperties%2F-1883119931) |
| [telephones](index.md#-1745067649%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#-1745067649%2FProperties%2F-1883119931) |
| [threeDigitsSecureCriteria](index.md#1159456722%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[threeDigitsSecureCriteria](index.md#1159456722%2FProperties%2F-1883119931) |
| [verifiedAmount](index.md#-1459812914%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[verifiedAmount](index.md#-1459812914%2FProperties%2F-1883119931) |
| [virtualCreditCardFlag](index.md#-1445092692%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[virtualCreditCardFlag](index.md#-1445092692%2FProperties%2F-1883119931) |
| [walletType](index.md#228074523%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[walletType](index.md#228074523%2FProperties%2F-1883119931) |
