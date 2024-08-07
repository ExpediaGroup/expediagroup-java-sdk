//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RateCalendar](index.md)

# RateCalendar

public final class [RateCalendar](index.md)

The lowest rate information of requested days

#### Parameters

JVM

| | |
|---|---|
| stayDate | Stay date for which the price is returned. |
| status | Represents whether the offer is currently available. |
| price |
| priceLevel | Indicates how that day's price compares to the other lowest price for that hotel over the searched date range. Prices will be bucketed into LOW/MEDIUM/HIGH. Here are the details for each `PriceLevel`: - HIGH: 65th percentile+ - MEDIUM: 30th Percentile+ - LOW: Anything lower than 30th percentile |

## Constructors

| | |
|---|---|
| [RateCalendar](-rate-calendar.md) | [JVM]<br>public [RateCalendar](index.md)[RateCalendar](-rate-calendar.md)([LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)stayDate, [RateCalendar.Status](-status/index.md)status, [RateCalendarPrice](../-rate-calendar-price/index.md)price, [RateCalendar.PriceLevel](-price-level/index.md)priceLevel) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [PriceLevel](-price-level/index.md) | [JVM]<br>public enum [PriceLevel](-price-level/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RateCalendar.PriceLevel](-price-level/index.md)&gt;<br>Indicates how that day's price compares to the other lowest price for that hotel over the searched date range. Prices will be bucketed into LOW/MEDIUM/HIGH. Here are the details for each `PriceLevel`: - HIGH: 65th percentile+ - MEDIUM: 30th Percentile+ - LOW: Anything lower than 30th percentile Values: HIGH,MEDIUM,LOW |
| [Status](-status/index.md) | [JVM]<br>public enum [Status](-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RateCalendar.Status](-status/index.md)&gt;<br>Represents whether the offer is currently available. Values: AVAILABLE,NOT_AVAILABLE |

## Properties

| Name | Summary |
|---|---|
| [price](index.md#1723328529%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RateCalendarPrice](../-rate-calendar-price/index.md)[price](index.md#1723328529%2FProperties%2F699445674) |
| [priceLevel](index.md#-425385723%2FProperties%2F699445674) | [JVM]<br>private final [RateCalendar.PriceLevel](-price-level/index.md)[priceLevel](index.md#-425385723%2FProperties%2F699445674) |
| [status](index.md#1445418542%2FProperties%2F699445674) | [JVM]<br>private final [RateCalendar.Status](-status/index.md)[status](index.md#1445418542%2FProperties%2F699445674) |
| [stayDate](index.md#1625291097%2FProperties%2F699445674) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[stayDate](index.md#1625291097%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RateCalendar.Builder](-builder/index.md)[builder](builder.md)() |
| [getPrice](get-price.md) | [JVM]<br>public final [RateCalendarPrice](../-rate-calendar-price/index.md)[getPrice](get-price.md)() |
| [getPriceLevel](get-price-level.md) | [JVM]<br>public final [RateCalendar.PriceLevel](-price-level/index.md)[getPriceLevel](get-price-level.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [RateCalendar.Status](-status/index.md)[getStatus](get-status.md)() |
| [getStayDate](get-stay-date.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getStayDate](get-stay-date.md)() |
