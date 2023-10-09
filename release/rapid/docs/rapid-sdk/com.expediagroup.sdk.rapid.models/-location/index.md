//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Location](index.md)

# Location

public final class [Location](index.md)

The property's location information.

#### Parameters

JVM

| |
|---|
| coordinates |
| obfuscatedCoordinates |
| obfuscationRequired | When this field is true, the `obfuscated_coordinates` must be used to display approximate location instead of the precise location of `coordinates`. |

## Constructors

| | |
|---|---|
| [Location](-location.md) | [JVM]<br>public [Location](index.md)[Location](-location.md)([Coordinates](../-coordinates/index.md)coordinates, [Coordinates](../-coordinates/index.md)obfuscatedCoordinates, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)obfuscationRequired) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [coordinates](index.md#-297684717%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Coordinates](../-coordinates/index.md)[coordinates](index.md#-297684717%2FProperties%2F700308213) |
| [obfuscatedCoordinates](index.md#-1176495945%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Coordinates](../-coordinates/index.md)[obfuscatedCoordinates](index.md#-1176495945%2FProperties%2F700308213) |
| [obfuscationRequired](index.md#-459435860%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[obfuscationRequired](index.md#-459435860%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Location.Builder](-builder/index.md)[builder](builder.md)() |
| [getCoordinates](get-coordinates.md) | [JVM]<br>public final [Coordinates](../-coordinates/index.md)[getCoordinates](get-coordinates.md)() |
| [getObfuscatedCoordinates](get-obfuscated-coordinates.md) | [JVM]<br>public final [Coordinates](../-coordinates/index.md)[getObfuscatedCoordinates](get-obfuscated-coordinates.md)() |
| [getObfuscationRequired](get-obfuscation-required.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getObfuscationRequired](get-obfuscation-required.md)() |
