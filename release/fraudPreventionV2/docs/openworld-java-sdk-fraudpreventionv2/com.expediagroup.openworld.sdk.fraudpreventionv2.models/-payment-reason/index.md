//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[PaymentReason](index.md)

# PaymentReason

[JVM]\
public enum [PaymentReason](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentReason](index.md)&gt;

The reason of payment. Possible values: - `FULL` - If the amount is paid i full for the order - `DEPOSIT` - The initial payment. Amount to be paid up front. - `SCHEDULED` - The amount to be payment based on a schedule for the remaining portion of the booking amount. - `SUBSEQUENT` - An additional amount paid that was not originally scheduled. - `DEFERRED` Values: FULL,DEPOSIT,SCHEDULED,SUBSEQUENT,DEFERRED

## Entries

| | |
|---|---|
| [FULL](-f-u-l-l/index.md) | [JVM]<br>[FULL](-f-u-l-l/index.md) |
| [DEPOSIT](-d-e-p-o-s-i-t/index.md) | [JVM]<br>[DEPOSIT](-d-e-p-o-s-i-t/index.md) |
| [SCHEDULED](-s-c-h-e-d-u-l-e-d/index.md) | [JVM]<br>[SCHEDULED](-s-c-h-e-d-u-l-e-d/index.md) |
| [SUBSEQUENT](-s-u-b-s-e-q-u-e-n-t/index.md) | [JVM]<br>[SUBSEQUENT](-s-u-b-s-e-q-u-e-n-t/index.md) |
| [DEFERRED](-d-e-f-e-r-r-e-d/index.md) | [JVM]<br>[DEFERRED](-d-e-f-e-r-r-e-d/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-445397937%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-445397937%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#2073332879%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#2073332879%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [PaymentReason](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[PaymentReason](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-d-e-f-e-r-r-e-d/index.md#-1675200216%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-d-e-f-e-r-r-e-d/index.md#-1675200216%2FProperties%2F-1883119931) |
