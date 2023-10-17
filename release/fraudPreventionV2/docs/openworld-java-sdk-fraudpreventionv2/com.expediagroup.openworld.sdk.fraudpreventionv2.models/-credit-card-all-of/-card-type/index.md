//[openworld-java-sdk-fraudpreventionv2](../../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../../index.md)/[CreditCardAllOf](../index.md)/[CardType](index.md)

# CardType

[JVM]\
public enum [CardType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[CreditCardAllOf.CardType](index.md)&gt;

The 'card_type' field value is an enum value which is associated with the payment method of the specific payment instrument. For credit card payment method ensure attributes mentioned in dictionary below are set to corresponding values only. Ensure to comply with the naming standards provided in below dictionary. For example, some Payment processors use “Japan Credit Bureau” but “JCB” should be used when calling Fraud API. Incorrect `card_type` - `brand` combination will result in data quality issues and result in degraded risk recommendation. 'card_type' is an enum value with the following mapping with Payment `brand` attribute: *       card_type            :          brand * -------------------------------------------------------- * `AMERICAN_EXPRESS`         : `AMERICAN_EXPRESS` * `DINERS_CLUB`              : `DINERS_CLUB_INTERNATIONAL` * `DINERS_CLUB`              : `BC_CARD` * `DISCOVER`                 : `DISCOVER` * `DISCOVER`                 : `BC_CARD` * `DISCOVER`                 : `DINERS_CLUB_INTERNATIONAL` * `DISCOVER`                 : `JCB` * `JCB`                      : `JCB` * `MASTER_CARD`              : `MASTER_CARD` * `MASTER_CARD`              : `MAESTRO` * `MASTER_CARD`              : `POSTEPAY_MASTERCARD` * `SOLO`                     : `SOLO` * `SWITCH`                   : `SWITCH` * `MAESTRO`                  : `MAESTRO` * `CHINA_UNION_PAY`          : `CHINA_UNION_PAY` * `VISA`                     : `VISA` * `VISA`                     : `VISA_DELTA` * `VISA`                     : `VISA_ELECTRON` * `VISA`                     : `CARTA_SI` * `VISA`                     : `CARTE_BLEUE` * `VISA`                     : `VISA_DANKORT` * `VISA`                     : `POSTEPAY_VISA_ELECTRON` Values: AMERICAN_EXPRESS,DINERS_CLUB,DISCOVER,JCB,MASTER_CARD,SOLO,SWITCH,MAESTRO,CHINA_UNION_PAY,VISA

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
| [VISA](-v-i-s-a/index.md) | [JVM]<br>[VISA](-v-i-s-a/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-1045473516%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-1045473516%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#875644842%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#875644842%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [CreditCardAllOf.CardType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[CreditCardAllOf.CardType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-v-i-s-a/index.md#2147446907%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-v-i-s-a/index.md#2147446907%2FProperties%2F-1883119931) |