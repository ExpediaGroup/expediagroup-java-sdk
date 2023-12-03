//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[CreditCardAllOf](../index.md)/[CardType](index.md)

# CardType

[JVM]\
public enum [CardType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[CreditCardAllOf.CardType](index.md)&gt;

The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` Values: AMERICAN_EXPRESS,DINERS_CLUB,DISCOVER,JCB,MASTER_CARD,SOLO,SWITCH,MAESTRO,CHINA_UNION_PAY,UATP,VISA

## Entries

| | |
|---|---|
| [AMERICAN_EXPRESS](-a-m-e-r-i-c-a-n_-e-x-p-r-e-s-s/index.md) | [JVM]<br>[AMERICAN_EXPRESS](-a-m-e-r-i-c-a-n_-e-x-p-r-e-s-s/index.md) |
| [DINERS_CLUB](-d-i-n-e-r-s_-c-l-u-b/index.md) | [JVM]<br>[DINERS_CLUB](-d-i-n-e-r-s_-c-l-u-b/index.md) |
| [DISCOVER](-d-i-s-c-o-v-e-r/index.md) | [JVM]<br>[DISCOVER](-d-i-s-c-o-v-e-r/index.md) |
| [JCB](-j-c-b/index.md) | [JVM]<br>[JCB](-j-c-b/index.md) |
| [MASTER_CARD](-m-a-s-t-e-r_-c-a-r-d/index.md) | [JVM]<br>[MASTER_CARD](-m-a-s-t-e-r_-c-a-r-d/index.md) |
| [SOLO](-s-o-l-o/index.md) | [JVM]<br>[SOLO](-s-o-l-o/index.md) |
| [SWITCH](-s-w-i-t-c-h/index.md) | [JVM]<br>[SWITCH](-s-w-i-t-c-h/index.md) |
| [MAESTRO](-m-a-e-s-t-r-o/index.md) | [JVM]<br>[MAESTRO](-m-a-e-s-t-r-o/index.md) |
| [CHINA_UNION_PAY](-c-h-i-n-a_-u-n-i-o-n_-p-a-y/index.md) | [JVM]<br>[CHINA_UNION_PAY](-c-h-i-n-a_-u-n-i-o-n_-p-a-y/index.md) |
| [UATP](-u-a-t-p/index.md) | [JVM]<br>[UATP](-u-a-t-p/index.md) |
| [VISA](-v-i-s-a/index.md) | [JVM]<br>[VISA](-v-i-s-a/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-1801136938%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[CreditCardAllOf.CardType](index.md)&gt;[entries](index.md#-1801136938%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#1089285461%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1089285461%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[CreditCardAllOf.CardType](index.md)&gt;[getEntries](get-entries.md)()<br>The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `UATP`                     : `UATP` * `UATP`                     : `UATP_SUPPLY` * `UATP`                     : `AIR_PLUS` * `UATP`                     : `UA_PASS_PLUS` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` Values: AMERICAN_EXPRESS,DINERS_CLUB,DISCOVER,JCB,MASTER_CARD,SOLO,SWITCH,MAESTRO,CHINA_UNION_PAY,UATP,VISA |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [CreditCardAllOf.CardType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[CreditCardAllOf.CardType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
