//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RateCalendar](index.md)/[RateCalendar](-rate-calendar.md)

# RateCalendar

[JVM]\

public [RateCalendar](index.md)[RateCalendar](-rate-calendar.md)([LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)stayDate, [RateCalendar.Status](-status/index.md)status, [RateCalendarPrice](../-rate-calendar-price/index.md)price, [RateCalendar.PriceLevel](-price-level/index.md)priceLevel)

#### Parameters

JVM

| | |
|---|---|
| stayDate | Stay date for which the price is returned. |
| status | Represents whether the offer is currently available. |
| price |
| priceLevel | Indicates how that day's price compares to the other lowest price for that hotel over the searched date range. Prices will be bucketed into LOW/MEDIUM/HIGH. Here are the details for each `PriceLevel`: - HIGH: 65th percentile+ - MEDIUM: 30th Percentile+ - LOW: Anything lower than 30th percentile |
