//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Amount](index.md)

# Amount

public final class [Amount](index.md)

#### Parameters

JVM

| | |
|---|---|
|  | `value` The amount required in payment for the product/order in local currency (including any taxes and fees). |
| currencyCode | The ISO  alpha-3 country code for the amount currency. |

## Constructors

| | |
|---|---|
| [Amount](-amount.md) | [JVM]<br>public [Amount](index.md)[Amount](-amount.md)([Double](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)value, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currencyCode) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currencyCode](index.md#255109573%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{3}$&quot;)<br>@Length(max = 3)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[currencyCode](index.md#255109573%2FProperties%2F-173342751) |
| [value](index.md#-2043518906%2FProperties%2F-173342751) | [JVM]<br>private final [Double](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)[value](index.md#-2043518906%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Amount.Builder](-builder/index.md)[builder](builder.md)() |
| [getCurrencyCode](get-currency-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCurrencyCode](get-currency-code.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [Double](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)[getValue](get-value.md)() |
