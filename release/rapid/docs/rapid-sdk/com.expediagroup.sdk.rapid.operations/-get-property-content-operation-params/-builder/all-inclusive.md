//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetPropertyContentOperationParams](../index.md)/[Builder](index.md)/[allInclusive](all-inclusive.md)

# allInclusive

[JVM]\

public final [GetPropertyContentOperationParams.Builder](index.md)[allInclusive](all-inclusive.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;allInclusive)

#### Parameters

JVM

| | |
|---|---|
| allInclusive | Search to include properties that have the requested `all_inclusive` values equal to true. If this parameter is not supplied, all `all_inclusive` scenarios are included. This parameter can be supplied multiple times with different values, which will include properties that match any of the requested scenarios.   * `all_rate_plans` - Return properties where `all_inclusive.all_rate_plans` is true.   * `some_rate_plans` = Return properties where `all_inclusive.some_rate_plans` is true. |
