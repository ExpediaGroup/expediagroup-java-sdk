//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getRatePlanType](get-rate-plan-type.md)

# getRatePlanType

[JVM]\

public final [GetLodgingListingsOperationParams.RatePlanType](-rate-plan-type/index.md)[getRatePlanType](get-rate-plan-type.md)()

**Note**: This parameter is visible to partners only by configuration. Please contact your Expedia Account Manager if you need this parameter.  To specify the desired rate plan types. The options are: - standalone : Ask for standalone rates - package : Ask for package rates, but standalone rate also may be returned if available.  Otherwise only standalone rate plans will be returned.  `WebSearchResult` and `WebDetails` links won't be returned for package rate.
