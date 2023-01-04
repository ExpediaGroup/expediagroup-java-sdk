
# Air

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**departureTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Local date and time of departure from original departure location, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. | 
**arrivalTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Local date and time of arrival to final destination location, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. | 
**airSegments** | [**kotlin.collections.List&lt;AirSegment&gt;**](AirSegment.md) | Additional airline and flight details for each of the trip segments. | 
**flightType** | [**inline**](#FlightType) | Identifies the type of air trip based on the air destinations. |  [optional]
**passengerNameRecord** | **kotlin.String** | Airline booking confirmation code for the trip. |  [optional]
**globalDistributionSystemType** | **kotlin.String** | Associated with Passenger Name Record (PNR). |  [optional]


<a name="FlightType"></a>
## Enum: flight_type
Name | Value
---- | -----
flightType | ROUNDTRIP, ONEWAY, MULTIPLE_DESTINATION



