//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.models](../../index.md)/[RateCalendar](../index.md)/[PriceLevel](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RateCalendar.PriceLevel](index.md)&gt;[getEntries](get-entries.md)()

Indicates how that day's price compares to the other lowest price for that hotel over the searched date range. Prices will be bucketed into LOW/MEDIUM/HIGH. Here are the details for each `PriceLevel`: - HIGH: 65th percentile+ - MEDIUM: 30th Percentile+ - LOW: Anything lower than 30th percentile Values: HIGH,MEDIUM,LOW
