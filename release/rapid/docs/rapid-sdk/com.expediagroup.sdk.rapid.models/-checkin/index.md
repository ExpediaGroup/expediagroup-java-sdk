//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Checkin](index.md)

# Checkin

public final class [Checkin](index.md)

The property's check-in information.

#### Parameters

JVM

| | |
|---|---|
|  | `24hour` Present if the property has 24-hour check-in. |
| beginTime | The time at which a property begins to allow check-ins. |
| endTime | The time at which a property stops allowing check-ins. |
| instructions | The property's check-in policy. |
| specialInstructions | Any special instructions for checking into this property that may be specific to this property. |
| minAge | The minimum age for a customer to be able to check-in at a property. |

## Constructors

| | |
|---|---|
| [Checkin](-checkin.md) | [JVM]<br>public [Checkin](index.md)[Checkin](-checkin.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)24hour, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)beginTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)endTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)instructions, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialInstructions, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)minAge) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [24hour](index.md#-1228707956%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[24hour](index.md#-1228707956%2FProperties%2F700308213) |
| [beginTime](index.md#1284662546%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[beginTime](index.md#1284662546%2FProperties%2F700308213) |
| [endTime](index.md#2096810208%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[endTime](index.md#2096810208%2FProperties%2F700308213) |
| [instructions](index.md#-1052209619%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[instructions](index.md#-1052209619%2FProperties%2F700308213) |
| [minAge](index.md#604044101%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[minAge](index.md#604044101%2FProperties%2F700308213) |
| [specialInstructions](index.md#1405834858%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specialInstructions](index.md#1405834858%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Checkin.Builder](-builder/index.md)[builder](builder.md)() |
| [get24hour](get24hour.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[get24hour](get24hour.md)() |
| [getBeginTime](get-begin-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBeginTime](get-begin-time.md)() |
| [getEndTime](get-end-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEndTime](get-end-time.md)() |
| [getInstructions](get-instructions.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInstructions](get-instructions.md)() |
| [getMinAge](get-min-age.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getMinAge](get-min-age.md)() |
| [getSpecialInstructions](get-special-instructions.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecialInstructions](get-special-instructions.md)() |
