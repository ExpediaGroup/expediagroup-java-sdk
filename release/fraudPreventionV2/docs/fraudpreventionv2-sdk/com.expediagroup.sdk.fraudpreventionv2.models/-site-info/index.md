//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[SiteInfo](index.md)

# SiteInfo

public final class [SiteInfo](index.md)

#### Parameters

JVM

| | |
|---|---|
| countryCode | The alpha-3 ISO code that represents a country name. |
| agentAssisted | Identifies if an agent assisted in booking travel for the customer. `False` if the order was directly booked by customer. |

## Constructors

| | |
|---|---|
| [SiteInfo](-site-info.md) | [JVM]<br>public [SiteInfo](index.md)[SiteInfo](-site-info.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)agentAssisted) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [agentAssisted](index.md#-400317267%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[agentAssisted](index.md#-400317267%2FProperties%2F-173342751) |
| [countryCode](index.md#1689220343%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{3}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#1689220343%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [SiteInfo.Builder](-builder/index.md)[builder](builder.md)() |
| [getAgentAssisted](get-agent-assisted.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getAgentAssisted](get-agent-assisted.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
