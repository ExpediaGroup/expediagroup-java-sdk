//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAdditionalAvailabilityOperationParams](../index.md)/[Builder](index.md)/[salesChannel](sales-channel.md)

# salesChannel

[JVM]\

public final [GetAdditionalAvailabilityOperationParams.Builder](index.md)[salesChannel](sales-channel.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)salesChannel)

#### Parameters

JVM

| | |
|---|---|
| salesChannel | Provide the sales channel if you wish to override the sales_channel provided in the previous call. EPS dynamically provides the best content for optimal conversion on each sales channel.<br> Note: Must specify this value for hard change requests.<br> * `website` - Standard website accessed from the customer's computer * `agent_tool` - Your own agent tool used by your call center or retail store agent * `mobile_app` - An application installed on a phone or tablet device * `mobile_web` - A web browser application on a phone or tablet device * `meta` - Rates will be passed to and displayed on a 3rd party comparison website * `cache` - Rates will be used to populate a local cache |
