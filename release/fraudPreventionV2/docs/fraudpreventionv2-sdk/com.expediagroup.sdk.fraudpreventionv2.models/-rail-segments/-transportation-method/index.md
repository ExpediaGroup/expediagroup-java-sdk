//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[RailSegments](../index.md)/[TransportationMethod](index.md)

# TransportationMethod

[JVM]\
public enum [TransportationMethod](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RailSegments.TransportationMethod](index.md)&gt;

This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories. Values: BUS,FERRY,PUBLIC_TRANSPORT,RAIL,TRAM,TRANSFER,OTHERS

## Entries

| | |
|---|---|
| [BUS](-b-u-s/index.md) | [JVM]<br>[BUS](-b-u-s/index.md) |
| [FERRY](-f-e-r-r-y/index.md) | [JVM]<br>[FERRY](-f-e-r-r-y/index.md) |
| [PUBLIC_TRANSPORT](-p-u-b-l-i-c_-t-r-a-n-s-p-o-r-t/index.md) | [JVM]<br>[PUBLIC_TRANSPORT](-p-u-b-l-i-c_-t-r-a-n-s-p-o-r-t/index.md) |
| [RAIL](-r-a-i-l/index.md) | [JVM]<br>[RAIL](-r-a-i-l/index.md) |
| [TRAM](-t-r-a-m/index.md) | [JVM]<br>[TRAM](-t-r-a-m/index.md) |
| [TRANSFER](-t-r-a-n-s-f-e-r/index.md) | [JVM]<br>[TRANSFER](-t-r-a-n-s-f-e-r/index.md) |
| [OTHERS](-o-t-h-e-r-s/index.md) | [JVM]<br>[OTHERS](-o-t-h-e-r-s/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-135532432%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RailSegments.TransportationMethod](index.md)&gt;[entries](index.md#-135532432%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#1520068463%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1520068463%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RailSegments.TransportationMethod](index.md)&gt;[getEntries](get-entries.md)()<br>This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories. Values: BUS,FERRY,PUBLIC_TRANSPORT,RAIL,TRAM,TRANSFER,OTHERS |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [RailSegments.TransportationMethod](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[RailSegments.TransportationMethod](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
