//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[PriceCheckOperationParams](../index.md)/[Builder](index.md)/[customerSessionId](customer-session-id.md)

# customerSessionId

[JVM]\

public final [PriceCheckOperationParams.Builder](index.md)[customerSessionId](customer-session-id.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

#### Parameters

JVM

| | |
|---|---|
| customerSessionId | Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
