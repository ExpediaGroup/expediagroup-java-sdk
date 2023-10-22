//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Payment](index.md)

# Payment

public interface [Payment](index.md)

The `method` field value is used as a discriminator, with the following mapping: * `CREDIT_CARD`: `CreditCard` * `PAYPAL`: `PayPal` * `POINTS`: `Points` * `GIFT_CARD`: `GiftCard` * `INTERNET_BANK_PAYMENT`: `InternetBankPayment` * `DIRECT_DEBIT`: `DirectDebit`

#### Parameters

JVM

| | |
|---|---|
| brand | The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS` * `UATP` * `UATP_SUPPLY` * `AIR_PLUS` * `US_PASS_PLUS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` |
| method |
| billingName |
| billingAddress |
| billingEmailAddress | Email address associated with the payment. |
| reason |
| authorizedAmount |
| verifiedAmount |
| threeDigitsSecureCriteria |
| operations |

#### Inheritors

| |
|---|
| [CreditCard](../-credit-card/index.md) |
| [DirectDebit](../-direct-debit/index.md) |
| [GiftCard](../-gift-card/index.md) |
| [InternetBankPayment](../-internet-bank-payment/index.md) |
| [PayPal](../-pay-pal/index.md) |
| [Points](../-points/index.md) |

## Types

| Name | Summary |
|---|---|
| [Brand](-brand/index.md) | [JVM]<br>public enum [Brand](-brand/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Payment.Brand](-brand/index.md)&gt;<br>The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS` * `UATP` * `UATP_SUPPLY` * `AIR_PLUS` * `US_PASS_PLUS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` Values: AMERICAN_EXPRESS,DINERS_CLUB_INTERNATIONAL,BC_CARD,DISCOVER,JCB,MASTER_CARD,MAESTRO,POSTEPAY_MASTERCARD,SOLO,SWITCH,CHINA_UNION_PAY,VISA,VISA_DELTA,VISA_ELECTRON,CARTA_SI,CARTE_BLEUE,VISA_DANKORT,POSTEPAY_VISA_ELECTRON,PAYPAL,EXPEDIA_REWARDS,AMEX_POINTS,BANK_OF_AMERICA_REWARDS,DISCOVER_POINTS,MASTER_CARD_POINTS,CITI_THANK_YOU_POINTS,MERRILL_LYNCH_REWARDS,WELLS_FARGO_POINTS,DELTA_SKY_MILES,UNITED_POINTS,DISCOVER_MILES,ALASKA_MILES,RBC_REWARDS,BILT_REWARDS,ORBUCKS,CHEAP_CASH,BONUS_PLUS,ULTIMATE_REWARDS,UATP,UATP_SUPPLY,AIR_PLUS,US_PASS_PLUS,GIFT_CARD,IBP,LOCAL_DEBIT_CARD,SOFORT,YANDEX,WEB_MONEY,QIWI,BITCOIN,ELV,INTER_COMPANY |

## Functions

| Name | Summary |
|---|---|
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public abstract [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public abstract [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public abstract [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public abstract [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public abstract [Payment.Brand](-brand/index.md)[getBrand](get-brand.md)() |
| [getMethod](get-method.md) | [JVM]<br>public abstract [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public abstract [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getReason](get-reason.md) | [JVM]<br>public abstract [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public abstract [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public abstract [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |
