//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[SaleScenario](index.md)

# SaleScenario

public final class [SaleScenario](index.md)

Provides the special scenarios that need to be taken into account when using this rate.

#### Parameters

JVM

| | |
|---|---|
|  | `package` If true, this rate has been provided to be bundled with car, air, etc. and displayed as a total package price.  If shopping in a cross-sell scenario and using the cross-sell rate option, this indicates that the rate is a package rate available to be sold as an add-on to an existing itinerary. |
| member | If true, this rate has a \&quot;Member Only Deal\&quot; discount applied to the rate.  Partners must be enabled to receive \&quot;Member Only Deals\&quot;. If interested, partners should speak to their account representatives.  This parameter can be used to merchandise if a \&quot;Member Only Deal\&quot; has been applied, which will help drive loyalty. In addition, it can be used by OTA's to create an opaque, but public shopping experience.  This value will always be false for requests where the sales_environment is equal to \&quot;hotel_package\&quot;. |
| corporate | If true, this rate is a corporate negotiated rate.  These rates provide additional value adds (e.g. free breakfast, free wifi, discount) and same-day cancellation. |
| distribution | If true, this rate is an EPS Optimized Distribution rate. These rates are procured exclusively for EPS distribution and may contain benefits such as larger marketing fee, less restrictive cancellation policies, additional value adds, or unique availability. |
| mobilePromotion | If true, this rate has an associated mobile promotion which can be advertised as a special mobile only deal. This will only be present when `include=sale_scenario.mobile_promotion` is passed as a request parameter. |

## Constructors

| | |
|---|---|
| [SaleScenario](-sale-scenario.md) | [JVM]<br>public [SaleScenario](index.md)[SaleScenario](-sale-scenario.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)package, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)member, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)corporate, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)distribution, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)mobilePromotion) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [corporate](index.md#1362172455%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[corporate](index.md#1362172455%2FProperties%2F700308213) |
| [distribution](index.md#261340202%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[distribution](index.md#261340202%2FProperties%2F700308213) |
| [member](index.md#-1660744300%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[member](index.md#-1660744300%2FProperties%2F700308213) |
| [mobilePromotion](index.md#-2142581589%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[mobilePromotion](index.md#-2142581589%2FProperties%2F700308213) |
| [package](index.md#-1089118938%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[package](index.md#-1089118938%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [SaleScenario.Builder](-builder/index.md)[builder](builder.md)() |
| [getCorporate](get-corporate.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getCorporate](get-corporate.md)() |
| [getDistribution](get-distribution.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getDistribution](get-distribution.md)() |
| [getMember](get-member.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMember](get-member.md)() |
| [getMobilePromotion](get-mobile-promotion.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMobilePromotion](get-mobile-promotion.md)() |
| [getPackage](get-package.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPackage](get-package.md)() |
