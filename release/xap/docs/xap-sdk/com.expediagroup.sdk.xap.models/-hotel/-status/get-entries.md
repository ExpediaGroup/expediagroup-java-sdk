//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.models](../../index.md)/[Hotel](../index.md)/[Status](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Hotel.Status](index.md)&gt;[getEntries](get-entries.md)()

Indicates whether there are available offers at the property during the dates requested, as well as information as to why.  Note that pricing will <u>only</u> be present in the API response for a status of `AVAILABLE`.  If there are no rooms available at the property for the dates requested, then `NOT_AVAILABLE` will be returned.  If there are available rooms, but none that meet the specific parameters of the search request, then one of the other messages will be returned. Values: AVAILABLE,NOT_AVAILABLE,ERROR,NUMBER_OF_ADULTS_NOT_ACCEPTED,NUMBER_OF_CHILDREN_NOT_ACCEPTED,NUMBER_OF_INFANTS_NOT_ACCEPTED,NUMBER_OF_PERSONS_NOT_ACCEPTED,CHECK_IN_AGE_NOT_ACCEPTED
