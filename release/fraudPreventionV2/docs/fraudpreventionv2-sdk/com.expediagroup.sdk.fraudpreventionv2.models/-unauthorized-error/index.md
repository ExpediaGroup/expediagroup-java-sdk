//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[UnauthorizedError](index.md)

# UnauthorizedError

public final class [UnauthorizedError](index.md)

Indicates that the token sent in the 'Authorization' header is either invalid or missing. Please check the value in the token field along with the token expiration time before retrying.

#### Parameters

JVM

| | |
|---|---|
| code | Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon. |
| message | A human-readable explanation of the error, specific to this error occurrence. |

## Constructors

| | |
|---|---|
| [UnauthorizedError](-unauthorized-error.md) | [JVM]<br>public [UnauthorizedError](index.md)[UnauthorizedError](-unauthorized-error.md)([UnauthorizedError.Code](-code/index.md)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Code](-code/index.md) | [JVM]<br>public enum [Code](-code/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[UnauthorizedError.Code](-code/index.md)&gt;<br>Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon. Values: UNAUTHORIZED,FORBIDDEN,NOT_FOUND,ORDER_PURCHASE_UPDATE_NOT_FOUND,TOO_MANY_REQUESTS,INTERNAL_SERVER_ERROR,BAD_GATEWAY,RETRYABLE_ORDER_PURCHASE_SCREEN_FAILURE,RETRYABLE_ORDER_PURCHASE_UPDATE_FAILURE,GATEWAY_TIMEOUT,BAD_REQUEST |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#698017688%2FProperties%2F-173342751) | [JVM]<br>private final [UnauthorizedError.Code](-code/index.md)[code](index.md#698017688%2FProperties%2F-173342751) |
| [message](index.md#-723281042%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#-723281042%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [UnauthorizedError.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [UnauthorizedError.Code](-code/index.md)[getCode](get-code.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |
