//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.operations](../../index.md)/[GetLodgingListingsOperationParams](../index.md)/[Builder](index.md)/[includedInventorySourceIds](included-inventory-source-ids.md)

# includedInventorySourceIds

[JVM]\

public final [GetLodgingListingsOperationParams.Builder](index.md)[includedInventorySourceIds](included-inventory-source-ids.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)includedInventorySourceIds)

#### Parameters

JVM

| | |
|---|---|
| includedInventorySourceIds | Querying with no `includedInventorySourceIds` parameter will return listings from all available inventory sources.  Query with the `includedInventorySourceIds` parameter included will only return listings from the requested inventory sources. All others will be left out.  `includedInventorySourceId=24` will return only Expedia lodging inventory.  `includedInventorySourceId=83` will return only Vrbo lodging inventory.  `includedInventorySourceId=24,83` will return both Expedia and Vrbo lodging inventory. |
