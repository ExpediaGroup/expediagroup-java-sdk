//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[When](index.md)

# When

public final class [When](index.md)

Indicate when to pay.

#### Parameters

JVM

| | |
|---|---|
| type | Indicates the time of the deposit collection. Options are: UPON_BOOKING The customer must pay the deposit when booking the property. DAYS_PRIOR The customer must pay the deposit a number of days before arriving at the property. UPON_ARRIVAL The customer must pay the deposit upon arriving at the property. |
|  | `value` This value will only be shown when Deposit Type is DAYS_PRIOR to indicate the number of days prior to check in when the deposit will be collected. |

## Constructors

| | |
|---|---|
| [When](-when.md) | [JVM]<br>public [When](index.md)[When](-when.md)([When.Type](-type/index.md)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[When.Type](-type/index.md)&gt;<br>Indicates the time of the deposit collection. Options are: UPON_BOOKING The customer must pay the deposit when booking the property. DAYS_PRIOR The customer must pay the deposit a number of days before arriving at the property. UPON_ARRIVAL The customer must pay the deposit upon arriving at the property. Values: UPON_BOOKING,DAYS_PRIOR,UPON_ARRIVAL |

## Properties

| Name | Summary |
|---|---|
| [type](index.md#-47401310%2FProperties%2F699445674) | [JVM]<br>private final [When.Type](-type/index.md)[type](index.md#-47401310%2FProperties%2F699445674) |
| [value](index.md#-544501139%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-544501139%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [When.Builder](-builder/index.md)[builder](builder.md)() |
| [getType](get-type.md) | [JVM]<br>public final [When.Type](-type/index.md)[getType](get-type.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
