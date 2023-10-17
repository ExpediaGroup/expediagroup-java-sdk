//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[ChargebackDetail](index.md)

# ChargebackDetail

public final class [ChargebackDetail](index.md)

Details related to the chargeback.

#### Parameters

JVM

| | |
|---|---|
| chargebackStatus | Identifies the chargeback status. Possible values are: -`RECEIVED` - The chargeback was received. -`REVERSAL` - The chargeback reversal was received. |
| chargebackReason | Reason for chargeback which can be `Fraud` or `Non Fraud`. |
| chargebackAmount |
| bankReasonCode | Unique code provided by the acquiring bank for the category of fraud. |
| chargebackReportedDateTime | Date and time when the chargeback was reported to the partner, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [ChargebackDetail](-chargeback-detail.md) | [JVM]<br>public [ChargebackDetail](index.md)[ChargebackDetail](-chargeback-detail.md)([ChargebackDetail.ChargebackStatus](-chargeback-status/index.md)chargebackStatus, [ChargebackDetail.ChargebackReason](-chargeback-reason/index.md)chargebackReason, [Amount](../-amount/index.md)chargebackAmount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankReasonCode, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)chargebackReportedDateTime) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [ChargebackReason](-chargeback-reason/index.md) | [JVM]<br>public enum [ChargebackReason](-chargeback-reason/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ChargebackDetail.ChargebackReason](-chargeback-reason/index.md)&gt;<br>Reason for chargeback which can be `Fraud` or `Non Fraud`. Values: FRAUD,NON_FRAUD |
| [ChargebackStatus](-chargeback-status/index.md) | [JVM]<br>public enum [ChargebackStatus](-chargeback-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ChargebackDetail.ChargebackStatus](-chargeback-status/index.md)&gt;<br>Identifies the chargeback status. Possible values are: -`RECEIVED` - The chargeback was received. -`REVERSAL` - The chargeback reversal was received. Values: RECEIVED,REVERSAL |

## Properties

| Name | Summary |
|---|---|
| [bankReasonCode](index.md#-2052158390%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bankReasonCode](index.md#-2052158390%2FProperties%2F-173342751) |
| [chargebackAmount](index.md#-1500179356%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[chargebackAmount](index.md#-1500179356%2FProperties%2F-173342751) |
| [chargebackReason](index.md#249402360%2FProperties%2F-173342751) | [JVM]<br>private final [ChargebackDetail.ChargebackReason](-chargeback-reason/index.md)[chargebackReason](index.md#249402360%2FProperties%2F-173342751) |
| [chargebackReportedDateTime](index.md#-361798354%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[chargebackReportedDateTime](index.md#-361798354%2FProperties%2F-173342751) |
| [chargebackStatus](index.md#2145023498%2FProperties%2F-173342751) | [JVM]<br>private final [ChargebackDetail.ChargebackStatus](-chargeback-status/index.md)[chargebackStatus](index.md#2145023498%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ChargebackDetail.Builder](-builder/index.md)[builder](builder.md)() |
| [getBankReasonCode](get-bank-reason-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBankReasonCode](get-bank-reason-code.md)() |
| [getChargebackAmount](get-chargeback-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getChargebackAmount](get-chargeback-amount.md)() |
| [getChargebackReason](get-chargeback-reason.md) | [JVM]<br>public final [ChargebackDetail.ChargebackReason](-chargeback-reason/index.md)[getChargebackReason](get-chargeback-reason.md)() |
| [getChargebackReportedDateTime](get-chargeback-reported-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getChargebackReportedDateTime](get-chargeback-reported-date-time.md)() |
| [getChargebackStatus](get-chargeback-status.md) | [JVM]<br>public final [ChargebackDetail.ChargebackStatus](-chargeback-status/index.md)[getChargebackStatus](get-chargeback-status.md)() |
