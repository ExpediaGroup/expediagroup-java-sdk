//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RatePlan](index.md)/[getRemainingCount](get-remaining-count.md)

# getRemainingCount

[JVM]\

public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRemainingCount](get-remaining-count.md)()

#### Parameters

JVM

| | |
|---|---|
| remainingCount | The number of rooms remaining through Expedia for this room type.  **NOTE**: This value does <u>NOT</u> represent the total number of rooms remaining at the hotel property, only the number of rooms allocated to Expedia for sale by the property that currently remain in Expedia's inventory.  When a hotel is listed as 'sold out' by Expedia there may still be rooms available for sale by the hotel through other channels.  Also note that the `RemainingCount` response element has a maximum returned value of 100, even if there are more than 100 rooms available within bookable Expedia inventory.  **CMA Compliance Note (UK)**: websites in the UK that display `remainingCount` should make it clear to consumers that this count refers to the number of rooms remaining within Expedia inventory - NOT the number remaining at the property. |
