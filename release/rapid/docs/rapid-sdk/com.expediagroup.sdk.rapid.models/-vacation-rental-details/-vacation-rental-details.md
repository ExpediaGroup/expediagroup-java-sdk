//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[VacationRentalDetails](index.md)/[VacationRentalDetails](-vacation-rental-details.md)

# VacationRentalDetails

[JVM]\

public [VacationRentalDetails](index.md)[VacationRentalDetails](-vacation-rental-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)registryNumber, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)privateHost, [PropertyManager](../-property-manager/index.md)propertyManager, [RentalAgreement](../-rental-agreement/index.md)rentalAgreement, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;houseRules, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [EnhancedHouseRules](../-enhanced-house-rules/index.md)&gt;enhancedHouseRules, [Amenity](../-amenity/index.md)amenities, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)vrboSrpId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingSource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)listingUnit, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[UnitConfiguration](../-unit-configuration/index.md)&gt;&gt;unitConfigurations, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)freeText)

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
| unitConfigurations | Map of the vacation rental unit configurations. The key value is the unit location. |
| freeText | A free text description that could contain significantly unstructured information that could impact the booking and should be displayed to customers. This field could contain html break tags `<br>` that may make display challenging. |
