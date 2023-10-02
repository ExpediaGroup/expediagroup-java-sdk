//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentSessions](index.md)

# PaymentSessions

public final class [PaymentSessions](index.md)

The payment registration response.

#### Parameters

JVM

| | |
|---|---|
| paymentSessionId | The registered payment session ID. |
| encodedInitConfig | A base64 encoded object which contains configuration needed to perform device fingerprinting. It is used in conjunction with the provided Javascript library for PSD2. |
| links |

## Constructors

| | |
|---|---|
| [PaymentSessions](-payment-sessions.md) | [JVM]<br>public [PaymentSessions](index.md)[PaymentSessions](-payment-sessions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)encodedInitConfig, [PaymentSessionsLinks](../-payment-sessions-links/index.md)links) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [encodedInitConfig](index.md#521826546%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[encodedInitConfig](index.md#521826546%2FProperties%2F700308213) |
| [links](index.md#1874523897%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PaymentSessionsLinks](../-payment-sessions-links/index.md)[links](index.md#1874523897%2FProperties%2F700308213) |
| [paymentSessionId](index.md#1555826493%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[paymentSessionId](index.md#1555826493%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentSessions.Builder](-builder/index.md)[builder](builder.md)() |
| [getEncodedInitConfig](get-encoded-init-config.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEncodedInitConfig](get-encoded-init-config.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [PaymentSessionsLinks](../-payment-sessions-links/index.md)[getLinks](get-links.md)() |
| [getPaymentSessionId](get-payment-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaymentSessionId](get-payment-session-id.md)() |
