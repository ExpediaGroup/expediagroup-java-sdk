//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[SettledRefundUpdateDetails](index.md)

# SettledRefundUpdateDetails

public final class [SettledRefundUpdateDetails](index.md)

Data that describes settled refund that should be updated.

#### Parameters

JVM

| | |
|---|---|
| refundSettlementDateTime | Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has settled at the participating financial institutions. |
| refundDepositDateTime | Date and time when the refund was deposited to the original form of payment. |
| acquirerReferenceNumber | A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions. |
| settlementId | Unique settlement identifier specific to the payment processor for the settlement transaction generated for a previously submitted payment refund. |
| refundSettledAmount |

## Constructors

| | |
|---|---|
| [SettledRefundUpdateDetails](-settled-refund-update-details.md) | [JVM]<br>public [SettledRefundUpdateDetails](index.md)[SettledRefundUpdateDetails](-settled-refund-update-details.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)refundSettlementDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)refundDepositDateTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)acquirerReferenceNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)settlementId, [Amount](../-amount/index.md)refundSettledAmount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [acquirerReferenceNumber](index.md#1202759695%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[acquirerReferenceNumber](index.md#1202759695%2FProperties%2F-173342751) |
| [refundDepositDateTime](index.md#-1947673242%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[refundDepositDateTime](index.md#-1947673242%2FProperties%2F-173342751) |
| [refundSettledAmount](index.md#-1658943730%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[refundSettledAmount](index.md#-1658943730%2FProperties%2F-173342751) |
| [refundSettlementDateTime](index.md#-2072541897%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[refundSettlementDateTime](index.md#-2072541897%2FProperties%2F-173342751) |
| [settlementId](index.md#1684142223%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[settlementId](index.md#1684142223%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [SettledRefundUpdateDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getAcquirerReferenceNumber](get-acquirer-reference-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAcquirerReferenceNumber](get-acquirer-reference-number.md)() |
| [getRefundDepositDateTime](get-refund-deposit-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getRefundDepositDateTime](get-refund-deposit-date-time.md)() |
| [getRefundSettledAmount](get-refund-settled-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getRefundSettledAmount](get-refund-settled-amount.md)() |
| [getRefundSettlementDateTime](get-refund-settlement-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getRefundSettlementDateTime](get-refund-settlement-date-time.md)() |
| [getSettlementId](get-settlement-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSettlementId](get-settlement-id.md)() |
