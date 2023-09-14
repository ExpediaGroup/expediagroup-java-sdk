//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverUnauthorizedError](index.md)

# AccountTakeoverUnauthorizedError

public final class [AccountTakeoverUnauthorizedError](index.md)

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
| [AccountTakeoverUnauthorizedError](-account-takeover-unauthorized-error.md) | [JVM]<br>public [AccountTakeoverUnauthorizedError](index.md)[AccountTakeoverUnauthorizedError](-account-takeover-unauthorized-error.md)([AccountTakeoverUnauthorizedError.Code](-code/index.md)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Code](-code/index.md) | [JVM]<br>public enum [Code](-code/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverUnauthorizedError.Code](-code/index.md)&gt;<br>Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon. Values: UNAUTHORIZED,FORBIDDEN,NOT_FOUND,ACCOUNT_UPDATE_NOT_FOUND,TOO_MANY_REQUESTS,INTERNAL_SERVER_ERROR,BAD_GATEWAY,RETRYABLE_ACCOUNT_SCREEN_FAILURE,RETRYABLE_ACCOUNT_UPDATE_FAILURE,GATEWAY_TIMEOUT,BAD_REQUEST |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountTakeoverUnauthorizedError.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [AccountTakeoverUnauthorizedError.Code](-code/index.md)[getCode](get-code.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#-223045116%2FProperties%2F-1883119931) | [JVM]<br>private final [AccountTakeoverUnauthorizedError.Code](-code/index.md)[code](index.md#-223045116%2FProperties%2F-1883119931) |
| [message](index.md#440779138%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#440779138%2FProperties%2F-1883119931) |
