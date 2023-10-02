//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Rate](index.md)/[getAvailableRooms](get-available-rooms.md)

# getAvailableRooms

[JVM]\

public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getAvailableRooms](get-available-rooms.md)()

#### Parameters

JVM

| | |
|---|---|
| availableRooms | The number of bookable rooms remaining with this rate in EPS inventory. Use this value to create rules for urgency messaging to alert users to low availability on busy travel dates or at popular properties. If the value returns as 2147483647 (max int value), the actual value could not be determined. Ensure your urgency messaging ignores such instances when returned. |
