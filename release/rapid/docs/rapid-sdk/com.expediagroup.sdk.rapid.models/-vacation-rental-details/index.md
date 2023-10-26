//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[VacationRentalDetails](index.md)

# VacationRentalDetails

public final class [VacationRentalDetails](index.md)

Details for vacation rental properties.

#### Parameters

JVM

| | |
|---|---|
| registryNumber | The property's registry number required by some jurisdictions. |
| privateHost | Indicates if a property has a private host. |
| propertyManager |
| rentalAgreement |
| houseRules | List of strings detailing house rules. |
| enhancedHouseRules | Map of enhanced house rules. |
| amenities |
| vrboSrpId | The Vrbo srp needed for link-off. |
| listingId | The listing id for a Vrbo property. |
| listingNumber | The listing number for a Vrbo property. |
| listingSource | The listing source. |
| listingUnit | The specific unit. |
| ipmName | The name of the IPM used to build guest messaging to inform travelers of the name of the IPM who will charge their card and/or send them a confirmation email. |
| unitConfigurations | Map of the vacation rental unit configurations. The key value is the unit location. |
| freeText | A free text description that could contain significantly unstructured information that could impact the booking and should be displayed to customers. This field could contain html break tags `<br>` that may make display challenging. |

## Constructors

| | |
|---|---|
| [VacationRentalDetails](-vacation-rental-details.md) | [JVM]<br>public [VacationRentalDetails](index.md)[VacationRentalDetails](-vacation-rental-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)registryNumber, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)privateHost, [PropertyManager](../-property-manager/index.md)propertyManager, [RentalAgreement](../-rental-agreement/index.md)rentalAgreement, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;houseRules, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [EnhancedHouseRules](../-enhanced-house-rules/index.md)&gt;enhancedHouseRules, [Amenity](../-amenity/index.md)amenities, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)vrboSrpId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingSource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingUnit, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ipmName, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UnitConfiguration](../-unit-configuration/index.md)&gt;&gt;unitConfigurations, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)freeText) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-745814659%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amenity](../-amenity/index.md)[amenities](index.md#-745814659%2FProperties%2F700308213) |
| [enhancedHouseRules](index.md#550863225%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [EnhancedHouseRules](../-enhanced-house-rules/index.md)&gt;[enhancedHouseRules](index.md#550863225%2FProperties%2F700308213) |
| [freeText](index.md#-364232115%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[freeText](index.md#-364232115%2FProperties%2F700308213) |
| [houseRules](index.md#-1000937009%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[houseRules](index.md#-1000937009%2FProperties%2F700308213) |
| [ipmName](index.md#1650970051%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ipmName](index.md#1650970051%2FProperties%2F700308213) |
| [listingId](index.md#847729877%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[listingId](index.md#847729877%2FProperties%2F700308213) |
| [listingNumber](index.md#-1385687833%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[listingNumber](index.md#-1385687833%2FProperties%2F700308213) |
| [listingSource](index.md#-557041579%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[listingSource](index.md#-557041579%2FProperties%2F700308213) |
| [listingUnit](index.md#1979840460%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[listingUnit](index.md#1979840460%2FProperties%2F700308213) |
| [privateHost](index.md#-862595703%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[privateHost](index.md#-862595703%2FProperties%2F700308213) |
| [propertyManager](index.md#-468502436%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PropertyManager](../-property-manager/index.md)[propertyManager](index.md#-468502436%2FProperties%2F700308213) |
| [registryNumber](index.md#1034223616%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[registryNumber](index.md#1034223616%2FProperties%2F700308213) |
| [rentalAgreement](index.md#473025262%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [RentalAgreement](../-rental-agreement/index.md)[rentalAgreement](index.md#473025262%2FProperties%2F700308213) |
| [unitConfigurations](index.md#1501307109%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UnitConfiguration](../-unit-configuration/index.md)&gt;&gt;[unitConfigurations](index.md#1501307109%2FProperties%2F700308213) |
| [vrboSrpId](index.md#-1671657551%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[vrboSrpId](index.md#-1671657551%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [VacationRentalDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [Amenity](../-amenity/index.md)[getAmenities](get-amenities.md)() |
| [getEnhancedHouseRules](get-enhanced-house-rules.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [EnhancedHouseRules](../-enhanced-house-rules/index.md)&gt;[getEnhancedHouseRules](get-enhanced-house-rules.md)() |
| [getFreeText](get-free-text.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFreeText](get-free-text.md)() |
| [getHouseRules](get-house-rules.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHouseRules](get-house-rules.md)() |
| [getIpmName](get-ipm-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getIpmName](get-ipm-name.md)() |
| [getListingId](get-listing-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getListingId](get-listing-id.md)() |
| [getListingNumber](get-listing-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getListingNumber](get-listing-number.md)() |
| [getListingSource](get-listing-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getListingSource](get-listing-source.md)() |
| [getListingUnit](get-listing-unit.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getListingUnit](get-listing-unit.md)() |
| [getPrivateHost](get-private-host.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPrivateHost](get-private-host.md)() |
| [getPropertyManager](get-property-manager.md) | [JVM]<br>public final [PropertyManager](../-property-manager/index.md)[getPropertyManager](get-property-manager.md)() |
| [getRegistryNumber](get-registry-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRegistryNumber](get-registry-number.md)() |
| [getRentalAgreement](get-rental-agreement.md) | [JVM]<br>public final [RentalAgreement](../-rental-agreement/index.md)[getRentalAgreement](get-rental-agreement.md)() |
| [getUnitConfigurations](get-unit-configurations.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UnitConfiguration](../-unit-configuration/index.md)&gt;&gt;[getUnitConfigurations](get-unit-configurations.md)() |
| [getVrboSrpId](get-vrbo-srp-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getVrboSrpId](get-vrbo-srp-id.md)() |
