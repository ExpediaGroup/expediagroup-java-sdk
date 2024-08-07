//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomPreference](index.md)

# RoomPreference

public final class [RoomPreference](index.md)

Container for room preferences.

#### Parameters

JVM

| | |
|---|---|
| type | The type of preference. Options are: SmokingPreference Bed |
|  | `value` The value of the room preference.  For SmokingPreference, options are  SmokingOrNonSmoking Smoking NonSmoking For supported Bed Types, please refer to the Related Links section at the bottom of the page. |

## Constructors

| | |
|---|---|
| [RoomPreference](-room-preference.md) | [JVM]<br>public [RoomPreference](index.md)[RoomPreference](-room-preference.md)([RoomPreference.Type](-type/index.md)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RoomPreference.Type](-type/index.md)&gt;<br>The type of preference. Options are: SmokingPreference Bed Values: SMOKING_PREFERENCE,BED |

## Properties

| Name | Summary |
|---|---|
| [type](index.md#-1181579906%2FProperties%2F699445674) | [JVM]<br>private final [RoomPreference.Type](-type/index.md)[type](index.md#-1181579906%2FProperties%2F699445674) |
| [value](index.md#-1344299247%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-1344299247%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomPreference.Builder](-builder/index.md)[builder](builder.md)() |
| [getType](get-type.md) | [JVM]<br>public final [RoomPreference.Type](-type/index.md)[getType](get-type.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
