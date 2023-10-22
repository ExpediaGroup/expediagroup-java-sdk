//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[GatewayTimeoutError](index.md)

# GatewayTimeoutError

public final class [GatewayTimeoutError](index.md)

Indicates that the API gateway has issues completing the request on time. Request can be retried if it is idempotent, If the issue persists, please reach out to support. For non-idempotent requests, please reach out to <support team> to know the status of your request before attempting retries.

#### Parameters

JVM

| | |
|---|---|
| code | Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon. |
| message | A human-readable explanation of the error, specific to this error occurrence. |

## Constructors

| | |
|---|---|
| [GatewayTimeoutError](-gateway-timeout-error.md) | [JVM]<br>public [GatewayTimeoutError](index.md)[GatewayTimeoutError](-gateway-timeout-error.md)([GatewayTimeoutError.Code](-code/index.md)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Code](-code/index.md) | [JVM]<br>public enum [Code](-code/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[GatewayTimeoutError.Code](-code/index.md)&gt;<br>Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon. Values: UNAUTHORIZED,FORBIDDEN,NOT_FOUND,ACCOUNT_UPDATE_NOT_FOUND,TOO_MANY_REQUESTS,INTERNAL_SERVER_ERROR,BAD_GATEWAY,RETRYABLE_ACCOUNT_SCREEN_FAILURE,RETRYABLE_ACCOUNT_UPDATE_FAILURE,GATEWAY_TIMEOUT,BAD_REQUEST |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#-2066944849%2FProperties%2F-173342751) | [JVM]<br>private final [GatewayTimeoutError.Code](-code/index.md)[code](index.md#-2066944849%2FProperties%2F-173342751) |
| [message](index.md#1455549175%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#1455549175%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GatewayTimeoutError.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [GatewayTimeoutError.Code](-code/index.md)[getCode](get-code.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |
