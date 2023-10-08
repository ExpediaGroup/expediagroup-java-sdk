//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[CommitChangeRoomRequestBody](index.md)

# CommitChangeRoomRequestBody

public final class [CommitChangeRoomRequestBody](index.md)

#### Parameters

JVM

| | |
|---|---|
| changeReferenceId | Your optional identifier for the change being executed. Only unique per itinerary. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| payments |

## Constructors

| | |
|---|---|
| [CommitChangeRoomRequestBody](-commit-change-room-request-body.md) | [JVM]<br>public [CommitChangeRoomRequestBody](index.md)[CommitChangeRoomRequestBody](-commit-change-room-request-body.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changeReferenceId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequestWithPhone](../-payment-request-with-phone/index.md)&gt;payments) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [changeReferenceId](index.md#62207856%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[changeReferenceId](index.md#62207856%2FProperties%2F700308213) |
| [payments](index.md#-623731673%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequestWithPhone](../-payment-request-with-phone/index.md)&gt;[payments](index.md#-623731673%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CommitChangeRoomRequestBody.Builder](-builder/index.md)[builder](builder.md)() |
| [getChangeReferenceId](get-change-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getChangeReferenceId](get-change-reference-id.md)() |
| [getPayments](get-payments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequestWithPhone](../-payment-request-with-phone/index.md)&gt;[getPayments](get-payments.md)() |
