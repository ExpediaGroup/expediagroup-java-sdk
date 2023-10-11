//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[BedGroupAvailability](index.md)

# BedGroupAvailability

public final class [BedGroupAvailability](index.md)

#### Parameters

JVM

| |
|---|
| links |
| id | Unique identifier for a bed group. |
| description | This is a display ready description of a bed configuration for this room. |
| configuration | The bed configuration for a given room. This array can be empty for the related bed group. |

## Constructors

| | |
|---|---|
| [BedGroupAvailability](-bed-group-availability.md) | [JVM]<br>public [BedGroupAvailability](index.md)[BedGroupAvailability](-bed-group-availability.md)([BedGroupAvailabilityLinks](../-bed-group-availability-links/index.md)links, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedGroupConfiguration](../-bed-group-configuration/index.md)&gt;configuration) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [configuration](index.md#-321503244%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedGroupConfiguration](../-bed-group-configuration/index.md)&gt;[configuration](index.md#-321503244%2FProperties%2F700308213) |
| [description](index.md#-1146733842%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#-1146733842%2FProperties%2F700308213) |
| [id](index.md#1916030133%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#1916030133%2FProperties%2F700308213) |
| [links](index.md#-2068597871%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BedGroupAvailabilityLinks](../-bed-group-availability-links/index.md)[links](index.md#-2068597871%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [BedGroupAvailability.Builder](-builder/index.md)[builder](builder.md)() |
| [getConfiguration](get-configuration.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedGroupConfiguration](../-bed-group-configuration/index.md)&gt;[getConfiguration](get-configuration.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [BedGroupAvailabilityLinks](../-bed-group-availability-links/index.md)[getLinks](get-links.md)() |
