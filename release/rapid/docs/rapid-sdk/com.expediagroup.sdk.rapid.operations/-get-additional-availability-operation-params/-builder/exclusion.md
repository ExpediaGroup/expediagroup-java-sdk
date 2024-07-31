//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAdditionalAvailabilityOperationParams](../index.md)/[Builder](index.md)/[exclusion](exclusion.md)

# exclusion

[JVM]\

public final [GetAdditionalAvailabilityOperationParams.Builder](index.md)[exclusion](exclusion.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;exclusion)

#### Parameters

JVM

| | |
|---|---|
| exclusion | Single exclusion type. Send multiple instances of this parameter to request multiple exclusions.<br> Note: Optional parameter for use with hard change requests. <br> * `refundable_damage_deposit` - Excludes Rapid supplied Vrbo rates with refundable damage deposits from the response. * `card_on_file` - Excludes Rapid supplied Vrbo rates with card-on-file damage collection from the response. |
