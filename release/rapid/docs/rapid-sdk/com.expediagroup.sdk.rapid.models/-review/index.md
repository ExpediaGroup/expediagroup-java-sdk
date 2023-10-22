//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Review](index.md)

# Review

public final class [Review](index.md)

A review object for a property.

#### Parameters

JVM

| | |
|---|---|
| verificationSource | Where this review has been verified from. |
| title | Title of this review. |
| dateSubmitted | When this review was made, in ISO 8601 format. |
| rating | The rating for this property given by the reviewer. Returns a value between 1.0 and 5.0. |
| reviewerName | The name of the person who wrote this review. |
| tripReason |
| travelCompanion |
| text | The text of the review itself. |

## Constructors

| | |
|---|---|
| [Review](-review.md) | [JVM]<br>public [Review](index.md)[Review](-review.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)verificationSource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)title, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)dateSubmitted, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rating, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)reviewerName, [TripReason](../-trip-reason/index.md)tripReason, [TravelCompanion](../-travel-companion/index.md)travelCompanion, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)text) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [dateSubmitted](index.md#842885854%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[dateSubmitted](index.md#842885854%2FProperties%2F700308213) |
| [rating](index.md#2039856402%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[rating](index.md#2039856402%2FProperties%2F700308213) |
| [reviewerName](index.md#2029400671%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[reviewerName](index.md#2029400671%2FProperties%2F700308213) |
| [text](index.md#161691650%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[text](index.md#161691650%2FProperties%2F700308213) |
| [title](index.md#-2052107821%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[title](index.md#-2052107821%2FProperties%2F700308213) |
| [travelCompanion](index.md#1094600409%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [TravelCompanion](../-travel-companion/index.md)[travelCompanion](index.md#1094600409%2FProperties%2F700308213) |
| [tripReason](index.md#760077414%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [TripReason](../-trip-reason/index.md)[tripReason](index.md#760077414%2FProperties%2F700308213) |
| [verificationSource](index.md#1528292281%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[verificationSource](index.md#1528292281%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Review.Builder](-builder/index.md)[builder](builder.md)() |
| [getDateSubmitted](get-date-submitted.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDateSubmitted](get-date-submitted.md)() |
| [getRating](get-rating.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRating](get-rating.md)() |
| [getReviewerName](get-reviewer-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getReviewerName](get-reviewer-name.md)() |
| [getText](get-text.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getText](get-text.md)() |
| [getTitle](get-title.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTitle](get-title.md)() |
| [getTravelCompanion](get-travel-companion.md) | [JVM]<br>public final [TravelCompanion](../-travel-companion/index.md)[getTravelCompanion](get-travel-companion.md)() |
| [getTripReason](get-trip-reason.md) | [JVM]<br>public final [TripReason](../-trip-reason/index.md)[getTripReason](get-trip-reason.md)() |
| [getVerificationSource](get-verification-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getVerificationSource](get-verification-source.md)() |
