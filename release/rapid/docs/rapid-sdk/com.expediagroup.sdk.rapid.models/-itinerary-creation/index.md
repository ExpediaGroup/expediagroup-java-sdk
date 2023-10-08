//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ItineraryCreation](index.md)

# ItineraryCreation

public final class [ItineraryCreation](index.md)

The book response.

#### Parameters

JVM

| | |
|---|---|
| itineraryId | The itinerary id. |
| links |
| encodedChallengeConfig | The challenge config that is required to perform payment challenge. This field will be available when payment challenge is needed. |
| traderInformation |

## Constructors

| | |
|---|---|
| [ItineraryCreation](-itinerary-creation.md) | [JVM]<br>public [ItineraryCreation](index.md)[ItineraryCreation](-itinerary-creation.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [ItineraryCreationLinks](../-itinerary-creation-links/index.md)links, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)encodedChallengeConfig, [TraderInformation](../-trader-information/index.md)traderInformation) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [encodedChallengeConfig](index.md#-1537144488%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[encodedChallengeConfig](index.md#-1537144488%2FProperties%2F700308213) |
| [itineraryId](index.md#-1245111835%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[itineraryId](index.md#-1245111835%2FProperties%2F700308213) |
| [links](index.md#1583867794%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ItineraryCreationLinks](../-itinerary-creation-links/index.md)[links](index.md#1583867794%2FProperties%2F700308213) |
| [traderInformation](index.md#-1485765331%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [TraderInformation](../-trader-information/index.md)[traderInformation](index.md#-1485765331%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ItineraryCreation.Builder](-builder/index.md)[builder](builder.md)() |
| [getEncodedChallengeConfig](get-encoded-challenge-config.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEncodedChallengeConfig](get-encoded-challenge-config.md)() |
| [getItineraryId](get-itinerary-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getItineraryId](get-itinerary-id.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [ItineraryCreationLinks](../-itinerary-creation-links/index.md)[getLinks](get-links.md)() |
| [getTraderInformation](get-trader-information.md) | [JVM]<br>public final [TraderInformation](../-trader-information/index.md)[getTraderInformation](get-trader-information.md)() |
