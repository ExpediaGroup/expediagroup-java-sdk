//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAvailabilityOperationParams](../index.md)/[Builder](index.md)/[occupancy](occupancy.md)

# occupancy

[JVM]\

public final [GetAvailabilityOperationParams.Builder](index.md)[occupancy](occupancy.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;occupancy)

#### Parameters

JVM

| | |
|---|---|
| occupancy | Defines the requested occupancy for a single room. Each room must have at least 1 adult occupant.<br> Format: `numberOfAdults[-firstChildAge[,nextChildAge]]`<br> To request multiple rooms (of the same type), include one instance of occupancy for each room requested. Up to 8 rooms may be requested or booked at once.<br> Examples: * 2 adults, one 9-year-old and one 4-year-old would be represented by `occupancy=2-9,4`.<br> * A multi-room request to lodge an additional 2 adults would be represented by `occupancy=2-9,4&occupancy=2` |
