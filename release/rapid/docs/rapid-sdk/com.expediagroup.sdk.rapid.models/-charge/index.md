//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Charge](index.md)

# Charge

public final class [Charge](index.md)

An object representing a charge. Information about the charge is provided in both the billable currency and the request currency.

#### Parameters

JVM

| |
|---|
| billableCurrency |
| requestCurrency |

## Constructors

| | |
|---|---|
| [Charge](-charge.md) | [JVM]<br>public [Charge](index.md)[Charge](-charge.md)([Amount](../-amount/index.md)billableCurrency, [Amount](../-amount/index.md)requestCurrency) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [billableCurrency](index.md#1756202265%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[billableCurrency](index.md#1756202265%2FProperties%2F700308213) |
| [requestCurrency](index.md#398683151%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[requestCurrency](index.md#398683151%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Charge.Builder](-builder/index.md)[builder](builder.md)() |
| [getBillableCurrency](get-billable-currency.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getBillableCurrency](get-billable-currency.md)() |
| [getRequestCurrency](get-request-currency.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getRequestCurrency](get-request-currency.md)() |
