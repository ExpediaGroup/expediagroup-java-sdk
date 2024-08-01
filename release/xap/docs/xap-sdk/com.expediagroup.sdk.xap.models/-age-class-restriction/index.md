//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[AgeClassRestriction](index.md)

# AgeClassRestriction

public final class [AgeClassRestriction](index.md)

Container for room occupancy rules based on the age of the guests.

#### Parameters

JVM

| | |
|---|---|
| ageClass | Categories for hotel guests, based on age. |
| ageMinimum | The minimum age defined in a particular `AgeClass`. |
| ageMaximum | The maximum age defined in a particular `AgeClass`.  If not specified, the `AgeClass` has no upper bound. |
| maxGuestCount | The max guest count allowed in a particular `AgeClass`. |

## Constructors

| | |
|---|---|
| [AgeClassRestriction](-age-class-restriction.md) | [JVM]<br>public [AgeClassRestriction](index.md)[AgeClassRestriction](-age-class-restriction.md)([AgeClassRestriction.AgeClass](-age-class/index.md)ageClass, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)ageMinimum, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)ageMaximum, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)maxGuestCount) |

## Types

| Name | Summary |
|---|---|
| [AgeClass](-age-class/index.md) | [JVM]<br>public enum [AgeClass](-age-class/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AgeClassRestriction.AgeClass](-age-class/index.md)&gt;<br>Categories for hotel guests, based on age. Values: ALL_AGES,SENIOR,ADULT,CHILD,INFANT,OTHER |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [ageClass](index.md#-1032076300%2FProperties%2F699445674) | [JVM]<br>private final [AgeClassRestriction.AgeClass](-age-class/index.md)[ageClass](index.md#-1032076300%2FProperties%2F699445674) |
| [ageMaximum](index.md#1592382604%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ageMaximum](index.md#1592382604%2FProperties%2F699445674) |
| [ageMinimum](index.md#-9346466%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ageMinimum](index.md#-9346466%2FProperties%2F699445674) |
| [maxGuestCount](index.md#-424118862%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[maxGuestCount](index.md#-424118862%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AgeClassRestriction.Builder](-builder/index.md)[builder](builder.md)() |
| [getAgeClass](get-age-class.md) | [JVM]<br>public final [AgeClassRestriction.AgeClass](-age-class/index.md)[getAgeClass](get-age-class.md)() |
| [getAgeMaximum](get-age-maximum.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getAgeMaximum](get-age-maximum.md)() |
| [getAgeMinimum](get-age-minimum.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getAgeMinimum](get-age-minimum.md)() |
| [getMaxGuestCount](get-max-guest-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getMaxGuestCount](get-max-guest-count.md)() |
