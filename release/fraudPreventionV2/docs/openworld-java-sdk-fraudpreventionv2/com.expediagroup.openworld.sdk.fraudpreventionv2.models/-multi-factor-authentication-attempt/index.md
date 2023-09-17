//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[MultiFactorAuthenticationAttempt](index.md)

# MultiFactorAuthenticationAttempt

public final class [MultiFactorAuthenticationAttempt](index.md)

Information specific to the update event by a user.

#### Parameters

JVM

| | |
|---|---|
| deliveryMethod | The delivery method of the Multi-Factor Authentication to a user. |
| status | The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge. |
| referenceId | The identifier related to a Multi-Factor Authentication attempt by the Partner's system to the Multi-Factor Authentication provider. |
| providerName | The vendor providing the Multi-Factor Authentication verification. |
| attemptCount | The number of attempts a user tried for this Multi-Factor Authentication. |
| updateStartDateTime | The local date and time the Multi-Factor Authentication was initiated to a user from the Partner's system, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| updateEndDateTime | The local date and time the Multi-Factor Authentication to a user ended in the Partner's system, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| telephone |
| emailAddress | Email address used for the Multi-Factor Authentication by a user. |

## Constructors

| | |
|---|---|
| [MultiFactorAuthenticationAttempt](-multi-factor-authentication-attempt.md) | [JVM]<br>public [MultiFactorAuthenticationAttempt](index.md)[MultiFactorAuthenticationAttempt](-multi-factor-authentication-attempt.md)([MultiFactorAuthenticationAttempt.DeliveryMethod](-delivery-method/index.md)deliveryMethod, [MultiFactorAuthenticationAttempt.Status](-status/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)referenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)providerName, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)attemptCount, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)updateStartDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)updateEndDateTime, [Telephone](../-telephone/index.md)telephone, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [DeliveryMethod](-delivery-method/index.md) | [JVM]<br>public enum [DeliveryMethod](-delivery-method/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[MultiFactorAuthenticationAttempt.DeliveryMethod](-delivery-method/index.md)&gt;<br>The delivery method of the Multi-Factor Authentication to a user. Values: EMAIL,SMS,VOICE,PUSH |
| [Status](-status/index.md) | [JVM]<br>public enum [Status](-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[MultiFactorAuthenticationAttempt.Status](-status/index.md)&gt;<br>The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,ABANDON,FAILED |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [MultiFactorAuthenticationAttempt.Builder](-builder/index.md)[builder](builder.md)() |
| [getAttemptCount](get-attempt-count.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getAttemptCount](get-attempt-count.md)() |
| [getDeliveryMethod](get-delivery-method.md) | [JVM]<br>public final [MultiFactorAuthenticationAttempt.DeliveryMethod](-delivery-method/index.md)[getDeliveryMethod](get-delivery-method.md)() |
| [getEmailAddress](get-email-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmailAddress](get-email-address.md)() |
| [getProviderName](get-provider-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getProviderName](get-provider-name.md)() |
| [getReferenceId](get-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getReferenceId](get-reference-id.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [MultiFactorAuthenticationAttempt.Status](-status/index.md)[getStatus](get-status.md)() |
| [getTelephone](get-telephone.md) | [JVM]<br>public final [Telephone](../-telephone/index.md)[getTelephone](get-telephone.md)() |
| [getUpdateEndDateTime](get-update-end-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getUpdateEndDateTime](get-update-end-date-time.md)() |
| [getUpdateStartDateTime](get-update-start-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getUpdateStartDateTime](get-update-start-date-time.md)() |

## Properties

| Name | Summary |
|---|---|
| [attemptCount](index.md#821740944%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[attemptCount](index.md#821740944%2FProperties%2F-1883119931) |
| [deliveryMethod](index.md#-87336963%2FProperties%2F-1883119931) | [JVM]<br>private final [MultiFactorAuthenticationAttempt.DeliveryMethod](-delivery-method/index.md)[deliveryMethod](index.md#-87336963%2FProperties%2F-1883119931) |
| [emailAddress](index.md#2028321754%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[emailAddress](index.md#2028321754%2FProperties%2F-1883119931) |
| [providerName](index.md#-1879973642%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[providerName](index.md#-1879973642%2FProperties%2F-1883119931) |
| [referenceId](index.md#366617666%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[referenceId](index.md#366617666%2FProperties%2F-1883119931) |
| [status](index.md#2129380768%2FProperties%2F-1883119931) | [JVM]<br>private final [MultiFactorAuthenticationAttempt.Status](-status/index.md)[status](index.md#2129380768%2FProperties%2F-1883119931) |
| [telephone](index.md#-973284732%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Telephone](../-telephone/index.md)[telephone](index.md#-973284732%2FProperties%2F-1883119931) |
| [updateEndDateTime](index.md#-316258661%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[updateEndDateTime](index.md#-316258661%2FProperties%2F-1883119931) |
| [updateStartDateTime](index.md#-2114471180%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[updateStartDateTime](index.md#-2114471180%2FProperties%2F-1883119931) |
