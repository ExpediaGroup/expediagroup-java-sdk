//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAvailabilityOperationParams](../index.md)/[Builder](index.md)/[ratePlanCount](rate-plan-count.md)

# ratePlanCount

[JVM]\

public final [GetAvailabilityOperationParams.Builder](index.md)[ratePlanCount](rate-plan-count.md)([BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)ratePlanCount)

#### Parameters

JVM

| | |
|---|---|
| ratePlanCount | The number of rates to return per property. The rates with the best value will be returned, e.g. a rate_plan_count=4 will return the best 4 rates, but the rates are not ordered from lowest to highest or vice versa in the response. Generally lowest rates will be prioritized.<br><br> The value must be between 1 and 250. |
