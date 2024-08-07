//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getLinks](get-links.md)

# getLinks

[JVM]\

public final [GetLodgingListingsOperationParams.Links](-links/index.md)[getLinks](get-links.md)()

Comma-separated list to specify the types of deep links. - WD (link to Web Details site) - WS (link to Web Search Result page) - AD (link for Details API) - RC (link for RateCalendar API) - WEB (include all website links) - API (links for Details and RateCalendar API)  There are two level of links returned in the API response: Property-level deeplinks and room-level deeplinks.  When requesting API deeplinks you will receive both a RateCalendar API link at the property level, and Details API links at the room level, since the Lodging Details API only displays information on rate plan offers.  When requesting AD deeplinks, you will <u>only</u> receive Details API links at the room level. `Links` node in property-level will be omitted.  If you are looking for more complete details on a single property via the API, you should do another search in the Lodging API for the single Hotel ID, with `contentDetails=high` to get all details back in return (note that you can only get back a maximum of 5 hotels when `contentDetails` is set to `high`).  **NOTE**: dateless searches will not return Details API links, since the Lodging Details API will only return details on a specific room offer for specific dates.
