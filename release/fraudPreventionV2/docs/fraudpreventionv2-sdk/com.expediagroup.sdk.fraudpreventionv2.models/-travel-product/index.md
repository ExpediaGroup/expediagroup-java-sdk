//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[TravelProduct](index.md)

# TravelProduct

public interface [TravelProduct](index.md)

The `type` field value is used as a discriminator, with the following mapping: * `CRUISE`: `Cruise` * `AIR`: `Air` * `CAR`: `Car` * `INSURANCE`: `Insurance` * `HOTEL`: `Hotel` * `RAIL`: `Rail`

#### Parameters

JVM

| |
|---|
| price |
| type |
| inventoryType | Type of inventory. Ensure attributes mentioned in dictionary below are set to corresponding values only. `inventory_type` has the following mapping with TravelProduct `type` attribute: *       inventory_type            :      type * ------------------------------------------------------ *  `Cruise`                       : `CRUISE` *  `Air`                          : `AIR` *  `Car`                          : `CAR` *  `Insurance`                    : `INSURANCE` *  `Hotel`                        : `HOTEL` *  `Rail`                         :  `RAIL` |
| inventorySource | Identifies the business model through which the supply is being sold. Merchant/Agency. * `MERCHANT` is used when Partner is the merchant of record for this order. * `AGENCY` is used when this order is through an agency booking. |
| travelersReferences | List of travelerGuids who are part of the traveling party on the order for the product. Information for each product and its required travelers should be provided in the API request. If the product booking does not require accompanying quest information then that does not need to be provided in the API request. Example: * For Air products, all travelers' details are required to complete the booking. * For Hotel products, typically the details on the person checking-in is required. * For Car products, typically only the primary driver information is required. If multiple traveler details are in the itinerary, this structure allows to fill up traveler details once in the `travelers` section, and then associate individual products to the respective travelers. This association is made using `traveler_id` field. A GUID can be generated for each object in the `travelers` section. The same GUID can be provided in the `traveler_references` below. The `travelers` array should have at least one `traveler` object, and each `traveler` object should have a `traveler_id` which is not necessarily an account id. Example: *   Travelers * ------------ *  A - GUID1 *  B - GUID2 *  C - GUID3 * *   Products * ------------ * Air *   GUID1, GUID2, GUID3 * Hotel *   GUID1 * Car *   GUID3 * Rail *   GUID2 * The example above demonstrates the association of travelers with various products. * All three travelers (A, B, and C) are associated with the Air product. * Traveler A is associated with the Hotel. * Traveler C is associated with the Car product. * Traveler B is associated with the Rail product. |
| payLater | The attribute serves as a boolean indicator that significantly influences the handling of payment information during the fraud prevention process: * When 'pay_later' is set to 'true':   - This configuration signals that payment information is optional for the booking. Travelers are given the choice to defer payment until they arrive at the rental counter following the completion of the booking.   - It is imperative for partners to explicitly set this attribute to 'true' when payment information can be optional for a particular booking scenario. * When 'pay_later' is set to 'false':   - In this mode, the attribute mandates the inclusion of payment information during the order purchase screen request. Travelers are required to provide payment details.   - Partners must exercise caution and ensure they supply the necessary payment information, as failure to do so in cases where 'pay_later' is set to 'false' will result in a 'Bad Request' error. This error helps maintain the consistency and accuracy of the fraud prevention process and payment handling. |

#### Inheritors

| |
|---|
| [Air](../-air/index.md) |
| [Car](../-car/index.md) |
| [Cruise](../-cruise/index.md) |
| [Hotel](../-hotel/index.md) |
| [Insurance](../-insurance/index.md) |
| [Rail](../-rail/index.md) |

## Types

| Name | Summary |
|---|---|
| [InventorySource](-inventory-source/index.md) | [JVM]<br>public enum [InventorySource](-inventory-source/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[TravelProduct.InventorySource](-inventory-source/index.md)&gt;<br>Identifies the business model through which the supply is being sold. Merchant/Agency. * `MERCHANT` is used when Partner is the merchant of record for this order. * `AGENCY` is used when this order is through an agency booking. Values: MERCHANT,AGENCY |

## Functions

| Name | Summary |
|---|---|
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public abstract [TravelProduct.InventorySource](-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public abstract [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPayLater](get-pay-later.md) | [JVM]<br>public abstract [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPayLater](get-pay-later.md)() |
| [getPrice](get-price.md) | [JVM]<br>public abstract [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public abstract [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public abstract [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |
