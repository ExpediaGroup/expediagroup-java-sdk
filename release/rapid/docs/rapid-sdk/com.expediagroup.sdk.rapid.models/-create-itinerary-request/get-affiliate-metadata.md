//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[CreateItineraryRequest](index.md)/[getAffiliateMetadata](get-affiliate-metadata.md)

# getAffiliateMetadata

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateMetadata](get-affiliate-metadata.md)()

#### Parameters

JVM

| | |
|---|---|
| affiliateMetadata | Field that stores up to 256 characters of additional metadata with the itinerary. Will be returned on all retrieve responses for this itinerary. The data must be in the format 'key1:value|key2:value|key3:value'. Other Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
