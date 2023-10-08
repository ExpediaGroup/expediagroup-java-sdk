//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ChangeRoomDetailsRequest](index.md)

# ChangeRoomDetailsRequest

public final class [ChangeRoomDetailsRequest](index.md)

#### Parameters

JVM

| | |
|---|---|
| givenName | First name of room guest. Max 60 characters. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| familyName | Last name of room guest. Max 60 characters. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| smoking | Specify if the guest would prefer a smoking room. This field is only a request and the property is not guaranteed to honor it, it will not override any non-smoking policies by the hotel. |
| specialRequest | Special requests to send to hotel (not guaranteed). Do not use this field to communicate B2B customer service requests or pass any sensitive personal or financial information (PII). Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| loyaltyId | A loyalty identifier for a hotel loyalty program associated with this room guest. |

## Constructors

| | |
|---|---|
| [ChangeRoomDetailsRequest](-change-room-details-request.md) | [JVM]<br>public [ChangeRoomDetailsRequest](index.md)[ChangeRoomDetailsRequest](-change-room-details-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)smoking, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyId) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [familyName](index.md#-1126929984%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[familyName](index.md#-1126929984%2FProperties%2F700308213) |
| [givenName](index.md#927638435%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[givenName](index.md#927638435%2FProperties%2F700308213) |
| [loyaltyId](index.md#1136727402%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[loyaltyId](index.md#1136727402%2FProperties%2F700308213) |
| [smoking](index.md#-1397166881%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[smoking](index.md#-1397166881%2FProperties%2F700308213) |
| [specialRequest](index.md#116815641%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specialRequest](index.md#116815641%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ChangeRoomDetailsRequest.Builder](-builder/index.md)[builder](builder.md)() |
| [getFamilyName](get-family-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFamilyName](get-family-name.md)() |
| [getGivenName](get-given-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGivenName](get-given-name.md)() |
| [getLoyaltyId](get-loyalty-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLoyaltyId](get-loyalty-id.md)() |
| [getSmoking](get-smoking.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getSmoking](get-smoking.md)() |
| [getSpecialRequest](get-special-request.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecialRequest](get-special-request.md)() |
