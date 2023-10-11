//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[BadRequestErrorAllOfCauses](index.md)

# BadRequestErrorAllOfCauses

public final class [BadRequestErrorAllOfCauses](index.md)

#### Parameters

JVM

| |
|---|
| code |
|  | `field` A JSON Path expression indicating which field, in the request body, caused the error. |
| message |

## Constructors

| | |
|---|---|
| [BadRequestErrorAllOfCauses](-bad-request-error-all-of-causes.md) | [JVM]<br>public [BadRequestErrorAllOfCauses](index.md)[BadRequestErrorAllOfCauses](-bad-request-error-all-of-causes.md)([BadRequestErrorAllOfCauses.Code](-code/index.md)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)field, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Code](-code/index.md) | [JVM]<br>public enum [Code](-code/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[BadRequestErrorAllOfCauses.Code](-code/index.md)&gt;<br>Values: MISSING_MANDATORY_PARAM,INVALID_PARAM,INVALID_FORMAT |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [BadRequestErrorAllOfCauses.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [BadRequestErrorAllOfCauses.Code](-code/index.md)[getCode](get-code.md)() |
| [getField](get-field.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getField](get-field.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#-226602884%2FProperties%2F-1883119931) | [JVM]<br>private final [BadRequestErrorAllOfCauses.Code](-code/index.md)[code](index.md#-226602884%2FProperties%2F-1883119931) |
| [field](index.md#723135351%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[field](index.md#723135351%2FProperties%2F-1883119931) |
| [message](index.md#1825495050%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#1825495050%2FProperties%2F-1883119931) |
