//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetReservationByItineraryIdOperationParams](index.md)/[getTest](get-test.md)

# getTest

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTest](get-test.md)()

The retrieve call has a test header that can be used to return set responses. Passing standard in the Test header will retrieve a test booking, and passing any of the errors listed below will return a stubbed error response that you can use to test your error handling code. Additionally, refer to the Test Request documentation for more details on how these header values are used. * `standard` - Requires valid test booking. * `service_unavailable` * `internal_server_error`
