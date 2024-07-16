//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[PutResumeBookingOperationContext](index.md)/[getTest](get-test.md)

# getTest

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTest](get-test.md)()

The resume call has a test header that can be used to return set responses with the following keywords:<br> * `standard` - Requires valid test held booking. * `service_unavailable` - Returns the HTTP 202 response caused by partial service unavailablity. * `internal_server_error`
