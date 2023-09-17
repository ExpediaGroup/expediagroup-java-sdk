//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[MultiFactorAuthenticationAttempt](index.md)/[MultiFactorAuthenticationAttempt](-multi-factor-authentication-attempt.md)

# MultiFactorAuthenticationAttempt

[JVM]\

public [MultiFactorAuthenticationAttempt](index.md)[MultiFactorAuthenticationAttempt](-multi-factor-authentication-attempt.md)([MultiFactorAuthenticationAttempt.DeliveryMethod](-delivery-method/index.md)deliveryMethod, [MultiFactorAuthenticationAttempt.Status](-status/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)referenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)providerName, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)attemptCount, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)updateStartDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)updateEndDateTime, [Telephone](../-telephone/index.md)telephone, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress)

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
