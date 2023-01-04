
# Hotel

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**hotelId** | **kotlin.String** | Unique hotel identifier assigned by the partner. | 
**hotelName** | **kotlin.String** | Name of the hotel. | 
**address** | [**Address**](Address.md) |  | 
**checkinTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Local date and time of the hotel check-in, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. | 
**checkoutTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Local date and time of the hotel check-out, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. | 
**priceWithheld** | **kotlin.Boolean** | Identifies if the product price was withheld from the customer during the booking process. |  [optional]
**roomCount** | **kotlin.Int** | Total number of rooms booked within the hotel product collection. |  [optional]



