//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[TransactionDetails](../index.md)/[CurrentOrderStatus](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[TransactionDetails.CurrentOrderStatus](index.md)&gt;[getEntries](get-entries.md)()

Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled. Values: IN_PROGRESS,COMPLETED
