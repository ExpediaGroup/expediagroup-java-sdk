//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ChangeRoomDetailsRequest](index.md)/[ChangeRoomDetailsRequest](-change-room-details-request.md)

# ChangeRoomDetailsRequest

[JVM]\

public [ChangeRoomDetailsRequest](index.md)[ChangeRoomDetailsRequest](-change-room-details-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)smoking, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyId, [Loyalty](../-loyalty/index.md)loyalty)

#### Parameters

JVM

| | |
|---|---|
| givenName | First name of room guest. Max 60 characters. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| familyName | Last name of room guest. Max 60 characters. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| smoking | Specify if the guest would prefer a smoking room. This field is only a request and the property is not guaranteed to honor it, it will not override any non-smoking policies by the hotel. |
| specialRequest | Special requests to send to hotel (not guaranteed). Do not use this field to communicate B2B customer service requests or pass any sensitive personal or financial information (PII). Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| loyaltyId | Deprecated. Please use the loyalty id inside the loyalty object. |
| loyalty |
