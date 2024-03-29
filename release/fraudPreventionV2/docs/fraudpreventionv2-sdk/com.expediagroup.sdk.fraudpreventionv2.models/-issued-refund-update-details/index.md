//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[IssuedRefundUpdateDetails](index.md)

# IssuedRefundUpdateDetails

public final class [IssuedRefundUpdateDetails](index.md)

Data that describes issued refund that should be updated.

#### Parameters

JVM

| | |
|---|---|
| refundIssuedDateTime | Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has issued at the participating financial institutions. |
| refundIssuedAmount |

## Constructors

| | |
|---|---|
| [IssuedRefundUpdateDetails](-issued-refund-update-details.md) | [JVM]<br>public [IssuedRefundUpdateDetails](index.md)[IssuedRefundUpdateDetails](-issued-refund-update-details.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)refundIssuedDateTime, [Amount](../-amount/index.md)refundIssuedAmount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [refundIssuedAmount](index.md#-1878367924%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[refundIssuedAmount](index.md#-1878367924%2FProperties%2F-173342751) |
| [refundIssuedDateTime](index.md#-629144151%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[refundIssuedDateTime](index.md#-629144151%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [IssuedRefundUpdateDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getRefundIssuedAmount](get-refund-issued-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getRefundIssuedAmount](get-refund-issued-amount.md)() |
| [getRefundIssuedDateTime](get-refund-issued-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getRefundIssuedDateTime](get-refund-issued-date-time.md)() |
