//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverSiteInfo](index.md)/[AccountTakeoverSiteInfo](-account-takeover-site-info.md)

# AccountTakeoverSiteInfo

[JVM]\

public [AccountTakeoverSiteInfo](index.md)[AccountTakeoverSiteInfo](-account-takeover-site-info.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)brandName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)locale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [AccountTakeoverSiteInfo.PlacementName](-placement-name/index.md)placementName)

#### Parameters

JVM

| | |
|---|---|
| brandName | The trademark brand name that is displayed to a user on the website. |
| locale | The locale of the website a user is accessing, which is separate from the user configured browser locale, in ISO 639-2 language code format and in ISO 3166-1 country code format. |
| name | Name of the website from which the event is generated. |
| placementName | The categorized name of the page where a user initiated event is being evaluated. - `LOGIN` - Applicable if the user initiated this account event from a login web page. - `PASSWORD_RESET` - Applicable if the user initiated this account event from a password reset web page. |
