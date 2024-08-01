//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[PaymentSchedule](index.md)

# PaymentSchedule

public final class [PaymentSchedule](index.md)

Contains information on the payment schedule.

#### Parameters

JVM

| | |
|---|---|
| due | Date/Time stamp when this installment/deposit should be paid by. |
| price |

## Constructors

| | |
|---|---|
| [PaymentSchedule](-payment-schedule.md) | [JVM]<br>public [PaymentSchedule](index.md)[PaymentSchedule](-payment-schedule.md)([LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)due, [PaymentSchedulePrice](../-payment-schedule-price/index.md)price) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [due](index.md#-509665713%2FProperties%2F699445674) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[due](index.md#-509665713%2FProperties%2F699445674) |
| [price](index.md#1110344474%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [PaymentSchedulePrice](../-payment-schedule-price/index.md)[price](index.md#1110344474%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentSchedule.Builder](-builder/index.md)[builder](builder.md)() |
| [getDue](get-due.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getDue](get-due.md)() |
| [getPrice](get-price.md) | [JVM]<br>public final [PaymentSchedulePrice](../-payment-schedule-price/index.md)[getPrice](get-price.md)() |
