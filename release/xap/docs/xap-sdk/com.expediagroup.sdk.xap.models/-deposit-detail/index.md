//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[DepositDetail](index.md)

# DepositDetail

public final class [DepositDetail](index.md)

Container for deposit policy details

#### Parameters

JVM

| | |
|---|---|
| type | Should be one of the following values: PERCENT The deposit amount is calculated as a percentage of the total booking cost. NIGHT The deposit amount is calculated in terms of nights plus tax. AMOUNT The deposit amount in USD. REMAINDER The deposit amount is equal to the booking cost minus any deposits that have been made before this point. |
|  | `value` Value to indicate how many/much of the type listed above is going to be charged as a deposit. |

## Constructors

| | |
|---|---|
| [DepositDetail](-deposit-detail.md) | [JVM]<br>public [DepositDetail](index.md)[DepositDetail](-deposit-detail.md)([DepositDetail.Type](-type/index.md)type, [When](../-when/index.md)when, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[DepositDetail.Type](-type/index.md)&gt;<br>Should be one of the following values: PERCENT The deposit amount is calculated as a percentage of the total booking cost. NIGHT The deposit amount is calculated in terms of nights plus tax. AMOUNT The deposit amount in USD. REMAINDER The deposit amount is equal to the booking cost minus any deposits that have been made before this point. Values: PERCENT,NIGHT,AMOUNT,REMAINDER |

## Properties

| Name | Summary |
|---|---|
| [type](index.md#240682447%2FProperties%2F699445674) | [JVM]<br>private final [DepositDetail.Type](-type/index.md)[type](index.md#240682447%2FProperties%2F699445674) |
| [value](index.md#-203839264%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-203839264%2FProperties%2F699445674) |
| [when](index.md#646900175%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [When](../-when/index.md)[when](index.md#646900175%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [DepositDetail.Builder](-builder/index.md)[builder](builder.md)() |
| [getType](get-type.md) | [JVM]<br>public final [DepositDetail.Type](-type/index.md)[getType](get-type.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [getWhen](get-when.md) | [JVM]<br>public final [When](../-when/index.md)[getWhen](get-when.md)() |
