//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[Hotel](index.md)/[getStatus](get-status.md)

# getStatus

[JVM]\

public final [Hotel.Status](-status/index.md)[getStatus](get-status.md)()

#### Parameters

JVM

| | |
|---|---|
| status | Indicates whether there are available offers at the property during the dates requested, as well as information as to why.  Note that pricing will <u>only</u> be present in the API response for a status of `AVAILABLE`.  If there are no rooms available at the property for the dates requested, then `NOT_AVAILABLE` will be returned.  If there are available rooms, but none that meet the specific parameters of the search request, then one of the other messages will be returned. |
