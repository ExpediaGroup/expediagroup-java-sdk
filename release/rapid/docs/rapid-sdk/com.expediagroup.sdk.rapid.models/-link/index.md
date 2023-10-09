//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Link](index.md)

# Link

public final class [Link](index.md)

An individual link.

#### Parameters

JVM

| | |
|---|---|
| method | The request method used to access the link. |
| href | The URL for the link. This can be absolute or relative. |
| expires | If the link expires, this will be the UTC date the link will expire, in ISO 8601 format. |

## Constructors

| | |
|---|---|
| [Link](-link.md) | [JVM]<br>public [Link](index.md)[Link](-link.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)method, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)href, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)expires) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [expires](index.md#-1610082731%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[expires](index.md#-1610082731%2FProperties%2F700308213) |
| [href](index.md#1742751526%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[href](index.md#1742751526%2FProperties%2F700308213) |
| [method](index.md#1214738736%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[method](index.md#1214738736%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Link.Builder](-builder/index.md)[builder](builder.md)() |
| [getExpires](get-expires.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getExpires](get-expires.md)() |
| [getHref](get-href.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHref](get-href.md)() |
| [getMethod](get-method.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMethod](get-method.md)() |
