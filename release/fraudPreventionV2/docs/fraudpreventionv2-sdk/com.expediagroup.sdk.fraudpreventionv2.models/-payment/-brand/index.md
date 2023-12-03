//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[Payment](../index.md)/[Brand](index.md)

# Brand

[JVM]\
public enum [Brand](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Payment.Brand](index.md)&gt;

The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `UATP`                      : `UATP` * `UATP_SUPPLY`               : `UATP` * `AIR_PLUS`                  : `UATP` * `UA_PASS_PLUS`              : `UATP` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` * `SEPA_ELV` Values: AMERICAN_EXPRESS,DINERS_CLUB_INTERNATIONAL,BC_CARD,DISCOVER,JCB,MASTER_CARD,MAESTRO,POSTEPAY_MASTERCARD,SOLO,SWITCH,CHINA_UNION_PAY,UATP,UATP_SUPPLY,AIR_PLUS,UA_PASS_PLUS,VISA,VISA_DELTA,VISA_ELECTRON,CARTA_SI,CARTE_BLEUE,VISA_DANKORT,POSTEPAY_VISA_ELECTRON,PAYPAL,EXPEDIA_REWARDS,AMEX_POINTS,BANK_OF_AMERICA_REWARDS,DISCOVER_POINTS,MASTER_CARD_POINTS,CITI_THANK_YOU_POINTS,MERRILL_LYNCH_REWARDS,WELLS_FARGO_POINTS,DELTA_SKY_MILES,UNITED_POINTS,DISCOVER_MILES,ALASKA_MILES,RBC_REWARDS,BILT_REWARDS,ORBUCKS,CHEAP_CASH,BONUS_PLUS,ULTIMATE_REWARDS,GIFT_CARD,IBP,LOCAL_DEBIT_CARD,SOFORT,YANDEX,WEB_MONEY,QIWI,BITCOIN,ELV,INTER_COMPANY,SEPA_ELV

## Entries

| | |
|---|---|
| [AMERICAN_EXPRESS](-a-m-e-r-i-c-a-n_-e-x-p-r-e-s-s/index.md) | [JVM]<br>[AMERICAN_EXPRESS](-a-m-e-r-i-c-a-n_-e-x-p-r-e-s-s/index.md) |
| [DINERS_CLUB_INTERNATIONAL](-d-i-n-e-r-s_-c-l-u-b_-i-n-t-e-r-n-a-t-i-o-n-a-l/index.md) | [JVM]<br>[DINERS_CLUB_INTERNATIONAL](-d-i-n-e-r-s_-c-l-u-b_-i-n-t-e-r-n-a-t-i-o-n-a-l/index.md) |
| [BC_CARD](-b-c_-c-a-r-d/index.md) | [JVM]<br>[BC_CARD](-b-c_-c-a-r-d/index.md) |
| [DISCOVER](-d-i-s-c-o-v-e-r/index.md) | [JVM]<br>[DISCOVER](-d-i-s-c-o-v-e-r/index.md) |
| [JCB](-j-c-b/index.md) | [JVM]<br>[JCB](-j-c-b/index.md) |
| [MASTER_CARD](-m-a-s-t-e-r_-c-a-r-d/index.md) | [JVM]<br>[MASTER_CARD](-m-a-s-t-e-r_-c-a-r-d/index.md) |
| [MAESTRO](-m-a-e-s-t-r-o/index.md) | [JVM]<br>[MAESTRO](-m-a-e-s-t-r-o/index.md) |
| [POSTEPAY_MASTERCARD](-p-o-s-t-e-p-a-y_-m-a-s-t-e-r-c-a-r-d/index.md) | [JVM]<br>[POSTEPAY_MASTERCARD](-p-o-s-t-e-p-a-y_-m-a-s-t-e-r-c-a-r-d/index.md) |
| [SOLO](-s-o-l-o/index.md) | [JVM]<br>[SOLO](-s-o-l-o/index.md) |
| [SWITCH](-s-w-i-t-c-h/index.md) | [JVM]<br>[SWITCH](-s-w-i-t-c-h/index.md) |
| [CHINA_UNION_PAY](-c-h-i-n-a_-u-n-i-o-n_-p-a-y/index.md) | [JVM]<br>[CHINA_UNION_PAY](-c-h-i-n-a_-u-n-i-o-n_-p-a-y/index.md) |
| [UATP](-u-a-t-p/index.md) | [JVM]<br>[UATP](-u-a-t-p/index.md) |
| [UATP_SUPPLY](-u-a-t-p_-s-u-p-p-l-y/index.md) | [JVM]<br>[UATP_SUPPLY](-u-a-t-p_-s-u-p-p-l-y/index.md) |
| [AIR_PLUS](-a-i-r_-p-l-u-s/index.md) | [JVM]<br>[AIR_PLUS](-a-i-r_-p-l-u-s/index.md) |
| [UA_PASS_PLUS](-u-a_-p-a-s-s_-p-l-u-s/index.md) | [JVM]<br>[UA_PASS_PLUS](-u-a_-p-a-s-s_-p-l-u-s/index.md) |
| [VISA](-v-i-s-a/index.md) | [JVM]<br>[VISA](-v-i-s-a/index.md) |
| [VISA_DELTA](-v-i-s-a_-d-e-l-t-a/index.md) | [JVM]<br>[VISA_DELTA](-v-i-s-a_-d-e-l-t-a/index.md) |
| [VISA_ELECTRON](-v-i-s-a_-e-l-e-c-t-r-o-n/index.md) | [JVM]<br>[VISA_ELECTRON](-v-i-s-a_-e-l-e-c-t-r-o-n/index.md) |
| [CARTA_SI](-c-a-r-t-a_-s-i/index.md) | [JVM]<br>[CARTA_SI](-c-a-r-t-a_-s-i/index.md) |
| [CARTE_BLEUE](-c-a-r-t-e_-b-l-e-u-e/index.md) | [JVM]<br>[CARTE_BLEUE](-c-a-r-t-e_-b-l-e-u-e/index.md) |
| [VISA_DANKORT](-v-i-s-a_-d-a-n-k-o-r-t/index.md) | [JVM]<br>[VISA_DANKORT](-v-i-s-a_-d-a-n-k-o-r-t/index.md) |
| [POSTEPAY_VISA_ELECTRON](-p-o-s-t-e-p-a-y_-v-i-s-a_-e-l-e-c-t-r-o-n/index.md) | [JVM]<br>[POSTEPAY_VISA_ELECTRON](-p-o-s-t-e-p-a-y_-v-i-s-a_-e-l-e-c-t-r-o-n/index.md) |
| [PAYPAL](-p-a-y-p-a-l/index.md) | [JVM]<br>[PAYPAL](-p-a-y-p-a-l/index.md) |
| [EXPEDIA_REWARDS](-e-x-p-e-d-i-a_-r-e-w-a-r-d-s/index.md) | [JVM]<br>[EXPEDIA_REWARDS](-e-x-p-e-d-i-a_-r-e-w-a-r-d-s/index.md) |
| [AMEX_POINTS](-a-m-e-x_-p-o-i-n-t-s/index.md) | [JVM]<br>[AMEX_POINTS](-a-m-e-x_-p-o-i-n-t-s/index.md) |
| [BANK_OF_AMERICA_REWARDS](-b-a-n-k_-o-f_-a-m-e-r-i-c-a_-r-e-w-a-r-d-s/index.md) | [JVM]<br>[BANK_OF_AMERICA_REWARDS](-b-a-n-k_-o-f_-a-m-e-r-i-c-a_-r-e-w-a-r-d-s/index.md) |
| [DISCOVER_POINTS](-d-i-s-c-o-v-e-r_-p-o-i-n-t-s/index.md) | [JVM]<br>[DISCOVER_POINTS](-d-i-s-c-o-v-e-r_-p-o-i-n-t-s/index.md) |
| [MASTER_CARD_POINTS](-m-a-s-t-e-r_-c-a-r-d_-p-o-i-n-t-s/index.md) | [JVM]<br>[MASTER_CARD_POINTS](-m-a-s-t-e-r_-c-a-r-d_-p-o-i-n-t-s/index.md) |
| [CITI_THANK_YOU_POINTS](-c-i-t-i_-t-h-a-n-k_-y-o-u_-p-o-i-n-t-s/index.md) | [JVM]<br>[CITI_THANK_YOU_POINTS](-c-i-t-i_-t-h-a-n-k_-y-o-u_-p-o-i-n-t-s/index.md) |
| [MERRILL_LYNCH_REWARDS](-m-e-r-r-i-l-l_-l-y-n-c-h_-r-e-w-a-r-d-s/index.md) | [JVM]<br>[MERRILL_LYNCH_REWARDS](-m-e-r-r-i-l-l_-l-y-n-c-h_-r-e-w-a-r-d-s/index.md) |
| [WELLS_FARGO_POINTS](-w-e-l-l-s_-f-a-r-g-o_-p-o-i-n-t-s/index.md) | [JVM]<br>[WELLS_FARGO_POINTS](-w-e-l-l-s_-f-a-r-g-o_-p-o-i-n-t-s/index.md) |
| [DELTA_SKY_MILES](-d-e-l-t-a_-s-k-y_-m-i-l-e-s/index.md) | [JVM]<br>[DELTA_SKY_MILES](-d-e-l-t-a_-s-k-y_-m-i-l-e-s/index.md) |
| [UNITED_POINTS](-u-n-i-t-e-d_-p-o-i-n-t-s/index.md) | [JVM]<br>[UNITED_POINTS](-u-n-i-t-e-d_-p-o-i-n-t-s/index.md) |
| [DISCOVER_MILES](-d-i-s-c-o-v-e-r_-m-i-l-e-s/index.md) | [JVM]<br>[DISCOVER_MILES](-d-i-s-c-o-v-e-r_-m-i-l-e-s/index.md) |
| [ALASKA_MILES](-a-l-a-s-k-a_-m-i-l-e-s/index.md) | [JVM]<br>[ALASKA_MILES](-a-l-a-s-k-a_-m-i-l-e-s/index.md) |
| [RBC_REWARDS](-r-b-c_-r-e-w-a-r-d-s/index.md) | [JVM]<br>[RBC_REWARDS](-r-b-c_-r-e-w-a-r-d-s/index.md) |
| [BILT_REWARDS](-b-i-l-t_-r-e-w-a-r-d-s/index.md) | [JVM]<br>[BILT_REWARDS](-b-i-l-t_-r-e-w-a-r-d-s/index.md) |
| [ORBUCKS](-o-r-b-u-c-k-s/index.md) | [JVM]<br>[ORBUCKS](-o-r-b-u-c-k-s/index.md) |
| [CHEAP_CASH](-c-h-e-a-p_-c-a-s-h/index.md) | [JVM]<br>[CHEAP_CASH](-c-h-e-a-p_-c-a-s-h/index.md) |
| [BONUS_PLUS](-b-o-n-u-s_-p-l-u-s/index.md) | [JVM]<br>[BONUS_PLUS](-b-o-n-u-s_-p-l-u-s/index.md) |
| [ULTIMATE_REWARDS](-u-l-t-i-m-a-t-e_-r-e-w-a-r-d-s/index.md) | [JVM]<br>[ULTIMATE_REWARDS](-u-l-t-i-m-a-t-e_-r-e-w-a-r-d-s/index.md) |
| [GIFT_CARD](-g-i-f-t_-c-a-r-d/index.md) | [JVM]<br>[GIFT_CARD](-g-i-f-t_-c-a-r-d/index.md) |
| [IBP](-i-b-p/index.md) | [JVM]<br>[IBP](-i-b-p/index.md) |
| [LOCAL_DEBIT_CARD](-l-o-c-a-l_-d-e-b-i-t_-c-a-r-d/index.md) | [JVM]<br>[LOCAL_DEBIT_CARD](-l-o-c-a-l_-d-e-b-i-t_-c-a-r-d/index.md) |
| [SOFORT](-s-o-f-o-r-t/index.md) | [JVM]<br>[SOFORT](-s-o-f-o-r-t/index.md) |
| [YANDEX](-y-a-n-d-e-x/index.md) | [JVM]<br>[YANDEX](-y-a-n-d-e-x/index.md) |
| [WEB_MONEY](-w-e-b_-m-o-n-e-y/index.md) | [JVM]<br>[WEB_MONEY](-w-e-b_-m-o-n-e-y/index.md) |
| [QIWI](-q-i-w-i/index.md) | [JVM]<br>[QIWI](-q-i-w-i/index.md) |
| [BITCOIN](-b-i-t-c-o-i-n/index.md) | [JVM]<br>[BITCOIN](-b-i-t-c-o-i-n/index.md) |
| [ELV](-e-l-v/index.md) | [JVM]<br>[ELV](-e-l-v/index.md) |
| [INTER_COMPANY](-i-n-t-e-r_-c-o-m-p-a-n-y/index.md) | [JVM]<br>[INTER_COMPANY](-i-n-t-e-r_-c-o-m-p-a-n-y/index.md) |
| [SEPA_ELV](-s-e-p-a_-e-l-v/index.md) | [JVM]<br>[SEPA_ELV](-s-e-p-a_-e-l-v/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#1981577946%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Payment.Brand](index.md)&gt;[entries](index.md#1981577946%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#2036237401%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#2036237401%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Payment.Brand](index.md)&gt;[getEntries](get-entries.md)()<br>The `brand` field value is the payment brand used for payment on this transaction. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `brand` - `card_type` combination will result in data quality issues and result in degraded risk recommendation. 'brand' is an enum value with the following mapping with CreditCard 'card_type' attribute: *       brand                 :      card_type * ------------------------------------------------------- * `AMERICAN_EXPRESS`          : `AMERICAN_EXPRESS` * `DINERS_CLUB_INTERNATIONAL` : `DINERS_CLUB` * `BC_CARD`                   : `DINERS_CLUB` * `DISCOVER`                  : `DISCOVER` * `BC_CARD`                   : `DISCOVER` * `DINERS_CLUB_INTERNATIONAL` : `DISCOVER` * `JCB`                       : `DISCOVER` * `JCB`                       : `JCB` * `MASTER_CARD`               : `MASTER_CARD` * `MAESTRO`                   : `MASTER_CARD` * `POSTEPAY_MASTERCARD`       : `MASTER_CARD` * `SOLO`                      : `SOLO` * `SWITCH`                    : `SWITCH` * `MAESTRO`                   : `MAESTRO` * `CHINA_UNION_PAY`           : `CHINA_UNION_PAY` * `UATP`                      : `UATP` * `UATP_SUPPLY`               : `UATP` * `AIR_PLUS`                  : `UATP` * `UA_PASS_PLUS`              : `UATP` * `VISA`                      : `VISA` * `VISA_DELTA`                : `VISA` * `VISA_ELECTRON`             : `VISA` * `CARTA_SI`                  : `VISA` * `CARTE_BLEUE`               : `VISA` * `VISA_DANKORT`              : `VISA` * `POSTEPAY_VISA_ELECTRON`    : `VISA` * `PAYPAL`                    :  'brand' with 'Points' payment_type is an enum value with following: * `EXPEDIA_REWARDS` * `AMEX_POINTS` * `BANK_OF_AMERICA_REWARDS` * `DISCOVER_POINTS` * `MASTER_CARD_POINTS` * `CITI_THANK_YOU_POINTS` * `MERRILL_LYNCH_REWARDS` * `WELLS_FARGO_POINTS` * `DELTA_SKY_MILES` * `UNITED_POINTS` * `DISCOVER_MILES` * `ALASKA_MILES` * `RBC_REWARDS` * `BILT_REWARDS` * `ORBUCKS` * `CHEAP_CASH` * `BONUS_PLUS` * `ULTIMATE_REWARDS`  'brand' with 'GiftCard' payment_type is an enum value with following: * `GIFT_CARD`  'brand' with 'InternetBankPayment' payment_type is an enum value with following: * `IBP` * `LOCAL_DEBIT_CARD` * `SOFORT` * `YANDEX` * `WEB_MONEY` * `QIWI` * `BITCOIN`  'brand' with 'DirectDebit' payment_type is an enum value with following: * `ELV` * `INTER_COMPANY` * `SEPA_ELV` Values: AMERICAN_EXPRESS,DINERS_CLUB_INTERNATIONAL,BC_CARD,DISCOVER,JCB,MASTER_CARD,MAESTRO,POSTEPAY_MASTERCARD,SOLO,SWITCH,CHINA_UNION_PAY,UATP,UATP_SUPPLY,AIR_PLUS,UA_PASS_PLUS,VISA,VISA_DELTA,VISA_ELECTRON,CARTA_SI,CARTE_BLEUE,VISA_DANKORT,POSTEPAY_VISA_ELECTRON,PAYPAL,EXPEDIA_REWARDS,AMEX_POINTS,BANK_OF_AMERICA_REWARDS,DISCOVER_POINTS,MASTER_CARD_POINTS,CITI_THANK_YOU_POINTS,MERRILL_LYNCH_REWARDS,WELLS_FARGO_POINTS,DELTA_SKY_MILES,UNITED_POINTS,DISCOVER_MILES,ALASKA_MILES,RBC_REWARDS,BILT_REWARDS,ORBUCKS,CHEAP_CASH,BONUS_PLUS,ULTIMATE_REWARDS,GIFT_CARD,IBP,LOCAL_DEBIT_CARD,SOFORT,YANDEX,WEB_MONEY,QIWI,BITCOIN,ELV,INTER_COMPANY,SEPA_ELV |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [Payment.Brand](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Payment.Brand](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
