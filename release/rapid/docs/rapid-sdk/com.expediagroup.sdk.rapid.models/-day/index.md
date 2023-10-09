//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Day](index.md)

# Day

public final class [Day](index.md)

#### Parameters

JVM

| | |
|---|---|
| date | Date associated to the provided information. |
| available | True if the property is available on the date. |
| checkin | Enumeration indicating the capability of check-in on the date.  `CHECKIN_VALID`: The associated date is valid for check in.  `CHECKIN_INVALID`: Generic or Unknown reason for being not being a valid day for check in.  `CHECKIN_INVALID_DUE_TO_BEING_IN_PAST`: The associated date is not valid for check in due to being in the past.  `CHECKIN_INVALID_DUE_TO_MIN_PRIOR_NOTIFICATION`:  The associated date is not valid for check in because checking in on this date would not meet the owner's minimum prior notification requirements.  `CHECKIN_INVALID_DUE_TO_MAX_FUTURE_BOOKING`: The associated date is not valid for check in because it is too far in the future.  `CHECKIN_INVALID_DUE_TO_NOT_AVAILABLE`: The associated date is not valid for check in because it is not available (ie. the date is already reserved).  `CHECKIN_INVALID_DUE_TO_NON_CHANGEOVER_DAY_OF_WEEK`: The associated date is not valid for check in because it falls on a day of the week that check in is prohibited.  `CHECKIN_INVALID_DUE_TO_CHANGEOVER_EXCLUSION`: The associated date is not valid for check in because check in was prohibited on that specific date.  `CHECKIN_INVALID_DUE_TO_MIN_STAY_NOT_ACHIEVABLE`: The associated date is not valid for check in because checking in on this date does not satisfy the minimum stay duration.  `CHECKIN_INVALID_DUE_TO_NO_VALID_CHECKOUT_WITHIN_CONSTRAINTS`: The associated date is not valid for check in because there is not an associated check out date that would allow the stay to satisfy stay constraints. |
| checkout | Enumeration indicating the capability of check-out on the date.  `CHECKOUT_VALID`: The associated date is valid for check out.  `CHECKOUT_INVALID`: The checkout validity value is invalid or unknown.  `CHECKOUT_INVALID_DUE_TO_NON_CHANGEOVER_DAY_OF_WEEK`: The associated date is not valid for check out because it falls on a day of the week that check out is prohibited.  `CHECKOUT_INVALID_DUE_TO_CHANGEOVER_EXCLUSION`: The associated date is not valid for check out because check out was prohibited on that specific date. |
| stayConstraints |

## Constructors

| | |
|---|---|
| [Day](-day.md) | [JVM]<br>public [Day](index.md)[Day](-day.md)([LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)date, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)available, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkin, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkout, [StayConstraints](../-stay-constraints/index.md)stayConstraints) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [available](index.md#1030498160%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[available](index.md#1030498160%2FProperties%2F700308213) |
| [checkin](index.md#-1586372212%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkin](index.md#-1586372212%2FProperties%2F700308213) |
| [checkout](index.md#572287835%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkout](index.md#572287835%2FProperties%2F700308213) |
| [date](index.md#711426035%2FProperties%2F700308213) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[date](index.md#711426035%2FProperties%2F700308213) |
| [stayConstraints](index.md#-381084260%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [StayConstraints](../-stay-constraints/index.md)[stayConstraints](index.md#-381084260%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Day.Builder](-builder/index.md)[builder](builder.md)() |
| [getAvailable](get-available.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getAvailable](get-available.md)() |
| [getCheckin](get-checkin.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckin](get-checkin.md)() |
| [getCheckout](get-checkout.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckout](get-checkout.md)() |
| [getDate](get-date.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getDate](get-date.md)() |
| [getStayConstraints](get-stay-constraints.md) | [JVM]<br>public final [StayConstraints](../-stay-constraints/index.md)[getStayConstraints](get-stay-constraints.md)() |
