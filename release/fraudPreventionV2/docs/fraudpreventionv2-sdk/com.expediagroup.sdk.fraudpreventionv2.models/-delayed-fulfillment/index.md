//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[DelayedFulfillment](index.md)

# DelayedFulfillment

public final class [DelayedFulfillment](index.md)

This field holds details about activity's capabilities and execution details related to inventory hold functionality.

#### Parameters

JVM

| | |
|---|---|
| isAvailable | This field indicates if the fulfillment of an activity is possible or not. |
| holdDurationValue | This field indicates the duration of the hold on an activity. |
| holdDurationUnitOfMeasure | This field indicates the unit of duration of the hold on an activity. |
| isDelayedCustomerConfirmation | This field indicates whether customer order confirmation can be delayed. Customer will receive ticket number, voucher ID or any other type of confirmation until transaction is successfully completed or approved by an analyst during the review process. |

## Constructors

| | |
|---|---|
| [DelayedFulfillment](-delayed-fulfillment.md) | [JVM]<br>public [DelayedFulfillment](index.md)[DelayedFulfillment](-delayed-fulfillment.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)isAvailable, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)holdDurationValue, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)holdDurationUnitOfMeasure, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)isDelayedCustomerConfirmation) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [holdDurationUnitOfMeasure](index.md#1469566499%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[holdDurationUnitOfMeasure](index.md#1469566499%2FProperties%2F-173342751) |
| [holdDurationValue](index.md#1950620629%2FProperties%2F-173342751) | [JVM]<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[holdDurationValue](index.md#1950620629%2FProperties%2F-173342751) |
| [isAvailable](is-available.md) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isAvailable](is-available.md) |
| [isDelayedCustomerConfirmation](is-delayed-customer-confirmation.md) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isDelayedCustomerConfirmation](is-delayed-customer-confirmation.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [DelayedFulfillment.Builder](-builder/index.md)[builder](builder.md)() |
| [getHoldDurationUnitOfMeasure](get-hold-duration-unit-of-measure.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHoldDurationUnitOfMeasure](get-hold-duration-unit-of-measure.md)() |
| [getHoldDurationValue](get-hold-duration-value.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getHoldDurationValue](get-hold-duration-value.md)() |
| [isAvailable](is-available.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isAvailable](is-available.md)() |
| [isDelayedCustomerConfirmation](is-delayed-customer-confirmation.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isDelayedCustomerConfirmation](is-delayed-customer-confirmation.md)() |
