//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomOccupancyPolicy](index.md)

# RoomOccupancyPolicy

public final class [RoomOccupancyPolicy](index.md)

Room occupancy policy.

#### Parameters

JVM

| | |
|---|---|
| maxGuestCount | The maximum number of guests allowed to stay in a room. |
| minCheckInAge | The minimum age required for check-in. |
| includedGuestCount | The number of guests included in base rate. |
| minGuestAge | The minimum age required for any guest staying in the room. |
| ageClassRestrictions | Container for room occupancy rules based on the age of the guests. |

## Constructors

| | |
|---|---|
| [RoomOccupancyPolicy](-room-occupancy-policy.md) | [JVM]<br>public [RoomOccupancyPolicy](index.md)[RoomOccupancyPolicy](-room-occupancy-policy.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)maxGuestCount, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)minCheckInAge, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)includedGuestCount, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)minGuestAge, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AgeClassRestriction](../-age-class-restriction/index.md)&gt;ageClassRestrictions) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [ageClassRestrictions](index.md#-769600898%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AgeClassRestriction](../-age-class-restriction/index.md)&gt;[ageClassRestrictions](index.md#-769600898%2FProperties%2F699445674) |
| [includedGuestCount](index.md#-1229431125%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[includedGuestCount](index.md#-1229431125%2FProperties%2F699445674) |
| [maxGuestCount](index.md#-1879233183%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[maxGuestCount](index.md#-1879233183%2FProperties%2F699445674) |
| [minCheckInAge](index.md#-253499720%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[minCheckInAge](index.md#-253499720%2FProperties%2F699445674) |
| [minGuestAge](index.md#-1364328189%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[minGuestAge](index.md#-1364328189%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomOccupancyPolicy.Builder](-builder/index.md)[builder](builder.md)() |
| [getAgeClassRestrictions](get-age-class-restrictions.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AgeClassRestriction](../-age-class-restriction/index.md)&gt;[getAgeClassRestrictions](get-age-class-restrictions.md)() |
| [getIncludedGuestCount](get-included-guest-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getIncludedGuestCount](get-included-guest-count.md)() |
| [getMaxGuestCount](get-max-guest-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMaxGuestCount](get-max-guest-count.md)() |
| [getMinCheckInAge](get-min-check-in-age.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMinCheckInAge](get-min-check-in-age.md)() |
| [getMinGuestAge](get-min-guest-age.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMinGuestAge](get-min-guest-age.md)() |
