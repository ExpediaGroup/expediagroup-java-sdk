//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CarAllOf](index.md)

# CarAllOf

public final class [CarAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| pickUpLocation | Location where the automobile will be picked up. |
| dropOffLocation | Location at which the automobile will be returned. |
| pickupTime | Local date and time the automobile will be picked-up, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| returnTime | Local date and time the automobile will be returned, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [CarAllOf](-car-all-of.md) | [JVM]<br>public [CarAllOf](index.md)[CarAllOf](-car-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)pickUpLocation, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)dropOffLocation, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)pickupTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)returnTime) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [dropOffLocation](index.md#-2099632362%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[dropOffLocation](index.md#-2099632362%2FProperties%2F-173342751) |
| [pickUpLocation](index.md#1682084638%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[pickUpLocation](index.md#1682084638%2FProperties%2F-173342751) |
| [pickupTime](index.md#148848166%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[pickupTime](index.md#148848166%2FProperties%2F-173342751) |
| [returnTime](index.md#1328805874%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[returnTime](index.md#1328805874%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CarAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getDropOffLocation](get-drop-off-location.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDropOffLocation](get-drop-off-location.md)() |
| [getPickUpLocation](get-pick-up-location.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPickUpLocation](get-pick-up-location.md)() |
| [getPickupTime](get-pickup-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getPickupTime](get-pickup-time.md)() |
| [getReturnTime](get-return-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getReturnTime](get-return-time.md)() |
