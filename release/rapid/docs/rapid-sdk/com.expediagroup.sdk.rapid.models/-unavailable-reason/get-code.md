//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[UnavailableReason](index.md)/[getCode](get-code.md)

# getCode

[JVM]\

public final [UnavailableReason.Code](-code/index.md)[getCode](get-code.md)()

#### Parameters

JVM

| | |
|---|---|
| code | The code representing the reason. * `adults_exceed_threshold` - Number of adults requested exceeds room threshold. `data` will contain the maximum value. * `children_exceed_threshold` - Number of children requested exceeds room threshold. `data` will contain the maximum value. * `infants_exceed_threshold` - Number of infants requested exceeds room threshold. `data` will contain the maximum value. * `minimum_child_age` - Child age requested is less than the minimum age specified for the room. `data` will contain the minimum value. * `maximum_occupancy` - Number of occupants exceed the specified room limit. `data` will contain the maximum value. * `checkin_not_allowed` - Check-in not allowed for this stay date. * `checkout_not_allowed` - Check-out not allowed for this stay date. * `minimum_stay` - Length of stay is less than minimum. `data` will contain the minimum value. * `maximum_stay` - Length of stay is greater than maximum. `data` will contain the maximum value. * `restricted_stay_lengths` - Some stay lengths are not available for this check-in date. `data` will contain the allowed lengths separated by pipe `|`. eg. `3|5|6` * `same_day_restrictions` - Room is not available due to same day booking restrictions. * `maximum_rooms` - Room count exceeds provider limit. `data` will contain the maximum value. * `children_not_supported` - The property is restricted to adults only. * `minimum_advance_purchase` - Minimum Advance Purchase requirement not met. `data` will contain the minimum value. * `maximum_advance_purchase` - Maximum Advance Purchase requirement not met. `data` will contain the maximum value. * `partial_inventory_available` - Some of the dates have no inventory available for the specified duration. `data` will contain the unavailable dates separated by pipe `|`. eg. `2023-10-21|2023-10-23` * `no_inventory_available` - No inventory is available for the specified duration. |
