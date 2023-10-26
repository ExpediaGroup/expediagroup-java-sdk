//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Property](index.md)

# Property

public interface [Property](index.md)

#### Parameters

JVM

| | |
|---|---|
| propertyId | Expedia property ID. |
| status | Helps determine which type of property response is returned. |
| score | A score to sort properties where the higher the value the better. It can be used to:<br> * Sort the properties on the response<br> * Sort properties across multiple responses in parallel searches for large regions<br> |

#### Inheritors

| |
|---|
| [PropertyAvailability](../-property-availability/index.md) |
| [PropertyUnavailability](../-property-unavailability/index.md) |

## Types

| Name | Summary |
|---|---|
| [Status](-status/index.md) | [JVM]<br>public enum [Status](-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Property.Status](-status/index.md)&gt;<br>Helps determine which type of property response is returned. Values: AVAILABLE,PARTIALLY_UNAVAILABLE |

## Functions

| Name | Summary |
|---|---|
| [getPropertyId](get-property-id.md) | [JVM]<br>public abstract [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPropertyId](get-property-id.md)() |
| [getScore](get-score.md) | [JVM]<br>public abstract [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getScore](get-score.md)() |
| [getStatus](get-status.md) | [JVM]<br>public abstract [Property.Status](-status/index.md)[getStatus](get-status.md)() |
