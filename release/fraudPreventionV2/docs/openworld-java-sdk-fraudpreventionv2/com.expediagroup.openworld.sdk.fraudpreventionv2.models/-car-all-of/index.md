//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[CarAllOf](index.md)

# CarAllOf

public final class [CarAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| pickUpLocation | Location where the automobile will be picked up. |
| dropOffLocation | Location at which the automobile will be returned. |
| pickupTime | Local date and time the automobile will be picked-up, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| returnTime | Local date and time the automobile will be returned, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [CarAllOf](-car-all-of.md) | [JVM]<br>public [CarAllOf](index.md)[CarAllOf](-car-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)pickUpLocation, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)dropOffLocation, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)pickupTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)returnTime) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CarAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getDropOffLocation](get-drop-off-location.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDropOffLocation](get-drop-off-location.md)() |
| [getPickUpLocation](get-pick-up-location.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPickUpLocation](get-pick-up-location.md)() |
| [getPickupTime](get-pickup-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getPickupTime](get-pickup-time.md)() |
| [getReturnTime](get-return-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getReturnTime](get-return-time.md)() |

## Properties

| Name | Summary |
|---|---|
| [dropOffLocation](index.md#17776316%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[dropOffLocation](index.md#17776316%2FProperties%2F-1883119931) |
| [pickUpLocation](index.md#2027482808%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[pickUpLocation](index.md#2027482808%2FProperties%2F-1883119931) |
| [pickupTime](index.md#1003976384%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[pickupTime](index.md#1003976384%2FProperties%2F-1883119931) |
| [returnTime](index.md#-2111033204%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[returnTime](index.md#-2111033204%2FProperties%2F-1883119931) |
