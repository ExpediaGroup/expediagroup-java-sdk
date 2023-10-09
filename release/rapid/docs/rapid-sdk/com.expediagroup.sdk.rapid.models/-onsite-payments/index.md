//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[OnsitePayments](index.md)

# OnsitePayments

public final class [OnsitePayments](index.md)

The property’s accepted forms of payments when onsite. See our [onsite payment types reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known payment type ID and name values.

#### Parameters

JVM

| | |
|---|---|
| currency | The currency accepted at the property. |
| types | The types of payments accepted at the property. |

## Constructors

| | |
|---|---|
| [OnsitePayments](-onsite-payments.md) | [JVM]<br>public [OnsitePayments](index.md)[OnsitePayments](-onsite-payments.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currency, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PaymentType](../-payment-type/index.md)&gt;types) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currency](index.md#721352825%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[currency](index.md#721352825%2FProperties%2F700308213) |
| [types](index.md#924826839%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PaymentType](../-payment-type/index.md)&gt;[types](index.md#924826839%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [OnsitePayments.Builder](-builder/index.md)[builder](builder.md)() |
| [getCurrency](get-currency.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCurrency](get-currency.md)() |
| [getTypes](get-types.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PaymentType](../-payment-type/index.md)&gt;[getTypes](get-types.md)() |
