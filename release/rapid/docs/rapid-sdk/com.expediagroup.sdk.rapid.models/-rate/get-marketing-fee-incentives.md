//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Rate](index.md)/[getMarketingFeeIncentives](get-marketing-fee-incentives.md)

# getMarketingFeeIncentives

[JVM]\

public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MarketingFeeIncentive](../-marketing-fee-incentive/index.md)&gt;[getMarketingFeeIncentives](get-marketing-fee-incentives.md)()

#### Parameters

JVM

| | |
|---|---|
| marketingFeeIncentives | An array of stay date ranges within this check-in / check-out range that have an incentive applied. The stay dates are determined by the would be check-in of that night. With a check-in date of 2023-09-01, and a check-out date of 2023-09-06, this would be a 5 night stay. A `marketing_fee_incentive` with start: 2023-09-02 and end: 2023-09-03 would mean 2 of the nights have an incentive applied. The 1st night is not part of the incentive, the 2nd and 3rd nights are part of the incentive, and the 4th and 5th nights are not part of the incentive. |
