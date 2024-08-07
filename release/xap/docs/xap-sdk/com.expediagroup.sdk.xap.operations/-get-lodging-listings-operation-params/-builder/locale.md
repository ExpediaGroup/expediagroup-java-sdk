//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.operations](../../index.md)/[GetLodgingListingsOperationParams](../index.md)/[Builder](index.md)/[locale](locale.md)

# locale

[JVM]\

public final [GetLodgingListingsOperationParams.Builder](index.md)[locale](locale.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)locale)

#### Parameters

JVM

| | |
|---|---|
| locale | `locale` is composed of language identifier and region identifier, connected by \&quot;_\&quot; that specifies the language in which the response will be returned.  You can find a link to the complete list of `locales` along with the Point of Sale List in [Supported Points of Sale](https://developers.expediagroup.com/xap/products/xap/lodging/references/supported-points-of-sale). Note that even though the Listings API supports localization for all `locales` listed in the list, all `locales` are not valid for all Points of Sale.  For example, Ecom US POS supports `en_US`, `es_MX` and `zh_CN`. For Ecom US POS, the Listings API will respond with content in Spanish for requests with either `locale=es_MX` or `es_US`. However, only the deeplinks for `locale=es_MX` should work properly and switch the website to Spanish, while the ones for locale=es_US will be fallen back to English.  If not specified in the query, the native language for that POS will be returned. And if more than one language is supported, the response will be returned in the first language depending on the language setting of the POS. |
