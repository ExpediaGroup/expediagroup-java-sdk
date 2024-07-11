//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetAdditionalAvailabilityOperationParams](index.md)/[getFilter](get-filter.md)

# getFilter

[JVM]\

public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getFilter](get-filter.md)()

Single filter type. Send multiple instances of this parameter to request multiple filters.<br> Note: Optional parameter for use with hard change requests.<br> This parameter cannot be set to `property_collect` if the existing booking is `expedia_collect` and vice versa.<br> * `refundable` - Filters results to only show fully refundable rates. * `expedia_collect` - Filters results to only show rates where payment is collected by Expedia at the time of booking. These properties can be eligible for payments via Expedia Affiliate Collect(EAC). * `property_collect` - Filters results to only show rates where payment is collected by the property after booking. This can include rates that require a deposit by the property, dependent upon the deposit policies. * `loyalty` - Filters results to only show rates that are eligible for loyalty points.
