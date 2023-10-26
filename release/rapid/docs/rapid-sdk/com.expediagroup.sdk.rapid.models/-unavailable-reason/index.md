//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[UnavailableReason](index.md)

# UnavailableReason

public final class [UnavailableReason](index.md)

An unavailable reason that suggests ways that the request could be modified to locate available rooms and rates.

#### Parameters

JVM

| | |
|---|---|
| code | The code representing the reason. * `adults_exceed_threshold` - Number of adults requested exceeds room threshold. `data` will contain the maximum value. * `children_exceed_threshold` - Number of children requested exceeds room threshold. `data` will contain the maximum value. * `infants_exceed_threshold` - Number of infants requested exceeds room threshold. `data` will contain the maximum value. * `minimum_child_age` - Child age requested is less than the minimum age specified for the room. `data` will contain the minimum value. * `maximum_occupancy` - Number of occupants exceed the specified room limit. `data` will contain the maximum value. * `checkin_not_allowed` - Check-in not allowed for this stay date. * `checkout_not_allowed` - Check-out not allowed for this stay date. * `minimum_stay` - Length of stay is less than minimum. `data` will contain the minimum value. * `maximum_stay` - Length of stay is greater than maximum. `data` will contain the maximum value. * `restricted_stay_lengths` - Some stay lengths are not available for this check-in date. `data` will contain the allowed lengths separated by pipe `|`. eg. `3|5|6` * `same_day_restrictions` - Room is not available due to same day booking restrictions. * `maximum_rooms` - Room count exceeds provider limit. `data` will contain the maximum value. * `children_not_supported` - The property is restricted to adults only. * `minimum_advance_purchase` - Minimum Advance Purchase requirement not met. `data` will contain the minimum value. * `maximum_advance_purchase` - Maximum Advance Purchase requirement not met. `data` will contain the maximum value. * `partial_inventory_available` - Some of the dates have no inventory available for the specified duration. `data` will contain the unavailable dates separated by pipe `|`. eg. `2023-10-21|2023-10-23` * `no_inventory_available` - No inventory is available for the specified duration. |
|  | `data` An associated value that provides helpful information for some codes. Not present for all codes. |

## Constructors

| | |
|---|---|
| [UnavailableReason](-unavailable-reason.md) | [JVM]<br>public [UnavailableReason](index.md)[UnavailableReason](-unavailable-reason.md)([UnavailableReason.Code](-code/index.md)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)data) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Code](-code/index.md) | [JVM]<br>public enum [Code](-code/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[UnavailableReason.Code](-code/index.md)&gt;<br>The code representing the reason. * `adults_exceed_threshold` - Number of adults requested exceeds room threshold. `data` will contain the maximum value. * `children_exceed_threshold` - Number of children requested exceeds room threshold. `data` will contain the maximum value. * `infants_exceed_threshold` - Number of infants requested exceeds room threshold. `data` will contain the maximum value. * `minimum_child_age` - Child age requested is less than the minimum age specified for the room. `data` will contain the minimum value. * `maximum_occupancy` - Number of occupants exceed the specified room limit. `data` will contain the maximum value. * `checkin_not_allowed` - Check-in not allowed for this stay date. * `checkout_not_allowed` - Check-out not allowed for this stay date. * `minimum_stay` - Length of stay is less than minimum. `data` will contain the minimum value. * `maximum_stay` - Length of stay is greater than maximum. `data` will contain the maximum value. * `restricted_stay_lengths` - Some stay lengths are not available for this check-in date. `data` will contain the allowed lengths separated by pipe `|`. eg. `3|5|6` * `same_day_restrictions` - Room is not available due to same day booking restrictions. * `maximum_rooms` - Room count exceeds provider limit. `data` will contain the maximum value. * `children_not_supported` - The property is restricted to adults only. * `minimum_advance_purchase` - Minimum Advance Purchase requirement not met. `data` will contain the minimum value. * `maximum_advance_purchase` - Maximum Advance Purchase requirement not met. `data` will contain the maximum value. * `partial_inventory_available` - Some of the dates have no inventory available for the specified duration. `data` will contain the unavailable dates separated by pipe `|`. eg. `2023-10-21|2023-10-23` * `no_inventory_available` - No inventory is available for the specified duration. Values: ADULTS_EXCEED_THRESHOLD,CHILDREN_EXCEED_THRESHOLD,INFANTS_EXCEED_THRESHOLD,MINIMUM_CHILD_AGE,MAXIMUM_OCCUPANCY,CHECKIN_NOT_ALLOWED,CHECKOUT_NOT_ALLOWED,MINIMUM_STAY,MAXIMUM_STAY,RESTRICTED_DATES,SAME_DAY_RESTRICTIONS,MAXIMUM_ROOMS,CHILDREN_NOT_SUPPORTED,MINIMUM_ADVANCE_PURCHASE,MAXIMUM_ADVANCE_PURCHASE,PARTIAL_INVENTORY_AVAILABLE,NO_INVENTORY_AVAILABLE |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#-1995198612%2FProperties%2F700308213) | [JVM]<br>private final [UnavailableReason.Code](-code/index.md)[code](index.md#-1995198612%2FProperties%2F700308213) |
| [data](index.md#346090575%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[data](index.md#346090575%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [UnavailableReason.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [UnavailableReason.Code](-code/index.md)[getCode](get-code.md)() |
| [getData](get-data.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getData](get-data.md)() |
