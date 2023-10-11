//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverSiteInfo](index.md)

# AccountTakeoverSiteInfo

public final class [AccountTakeoverSiteInfo](index.md)

Information specific to the Partner's website through which a transaction was made.

#### Parameters

JVM

| | |
|---|---|
| brandName | The trademark brand name that is displayed to a user on the website. |
| locale | The locale of the website a user is accessing, which is separate from the user configured browser locale, in ISO 639-2 language code format and in ISO 3166-1 country code format. |
| name | Name of the website from which the event is generated. |
| placementName | The categorized name of the page where a user initiated event is being evaluated. - `LOGIN` - Applicable if the user initiated this account event from a login web page. - `PASSWORD_RESET` - Applicable if the user initiated this account event from a password reset web page. |

## Constructors

| | |
|---|---|
| [AccountTakeoverSiteInfo](-account-takeover-site-info.md) | [JVM]<br>public [AccountTakeoverSiteInfo](index.md)[AccountTakeoverSiteInfo](-account-takeover-site-info.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)brandName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)locale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [AccountTakeoverSiteInfo.PlacementName](-placement-name/index.md)placementName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [PlacementName](-placement-name/index.md) | [JVM]<br>public enum [PlacementName](-placement-name/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverSiteInfo.PlacementName](-placement-name/index.md)&gt;<br>The categorized name of the page where a user initiated event is being evaluated. - `LOGIN` - Applicable if the user initiated this account event from a login web page. - `PASSWORD_RESET` - Applicable if the user initiated this account event from a password reset web page. Values: LOGIN,PASSWORD_RESET |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountTakeoverSiteInfo.Builder](-builder/index.md)[builder](builder.md)() |
| [getBrandName](get-brand-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBrandName](get-brand-name.md)() |
| [getLocale](get-locale.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLocale](get-locale.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getPlacementName](get-placement-name.md) | [JVM]<br>public final [AccountTakeoverSiteInfo.PlacementName](-placement-name/index.md)[getPlacementName](get-placement-name.md)() |

## Properties

| Name | Summary |
|---|---|
| [brandName](index.md#-1012320396%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[brandName](index.md#-1012320396%2FProperties%2F-1883119931) |
| [locale](index.md#2064466202%2FProperties%2F-1883119931) | [JVM]<br>@Pattern(regexp = &quot;^([a-z]{2}-[A-Z]{2})$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[locale](index.md#2064466202%2FProperties%2F-1883119931) |
| [name](index.md#174223305%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#174223305%2FProperties%2F-1883119931) |
| [placementName](index.md#-1210804138%2FProperties%2F-1883119931) | [JVM]<br>private final [AccountTakeoverSiteInfo.PlacementName](-placement-name/index.md)[placementName](index.md#-1210804138%2FProperties%2F-1883119931) |
