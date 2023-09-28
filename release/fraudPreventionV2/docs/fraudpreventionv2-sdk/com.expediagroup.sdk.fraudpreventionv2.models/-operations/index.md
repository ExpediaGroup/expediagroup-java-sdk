//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Operations](index.md)

# Operations

public final class [Operations](index.md)

All operations related to a payment throughout its lifespan. An operation represents an event external to Fraud Prevention Service that specifies to perform a payment operation. Possible operation types include:  - `Verify`  - `Authorize`  - `AuthorizeReversal`  - `Capture`  - `Refund`

#### Parameters

JVM

| |
|---|
| verify |
| authorize |
| authorizeReversal |
| capture |
| refunds |

## Constructors

| | |
|---|---|
| [Operations](-operations.md) | [JVM]<br>public [Operations](index.md)[Operations](-operations.md)([Verify](../-verify/index.md)verify, [Authorize](../-authorize/index.md)authorize, [AuthorizeReversal](../-authorize-reversal/index.md)authorizeReversal, [Capture](../-capture/index.md)capture, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Refund](../-refund/index.md)&gt;refunds) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [authorize](index.md#-385009094%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Authorize](../-authorize/index.md)[authorize](index.md#-385009094%2FProperties%2F-173342751) |
| [authorizeReversal](index.md#1727092620%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [AuthorizeReversal](../-authorize-reversal/index.md)[authorizeReversal](index.md#1727092620%2FProperties%2F-173342751) |
| [capture](index.md#-1767479555%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Capture](../-capture/index.md)[capture](index.md#-1767479555%2FProperties%2F-173342751) |
| [refunds](index.md#1768612840%2FProperties%2F-173342751) | [JVM]<br>@Size(max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Refund](../-refund/index.md)&gt;[refunds](index.md#1768612840%2FProperties%2F-173342751) |
| [verify](index.md#1447322846%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Verify](../-verify/index.md)[verify](index.md#1447322846%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Operations.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthorize](get-authorize.md) | [JVM]<br>public final [Authorize](../-authorize/index.md)[getAuthorize](get-authorize.md)() |
| [getAuthorizeReversal](get-authorize-reversal.md) | [JVM]<br>public final [AuthorizeReversal](../-authorize-reversal/index.md)[getAuthorizeReversal](get-authorize-reversal.md)() |
| [getCapture](get-capture.md) | [JVM]<br>public final [Capture](../-capture/index.md)[getCapture](get-capture.md)() |
| [getRefunds](get-refunds.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Refund](../-refund/index.md)&gt;[getRefunds](get-refunds.md)() |
| [getVerify](get-verify.md) | [JVM]<br>public final [Verify](../-verify/index.md)[getVerify](get-verify.md)() |
