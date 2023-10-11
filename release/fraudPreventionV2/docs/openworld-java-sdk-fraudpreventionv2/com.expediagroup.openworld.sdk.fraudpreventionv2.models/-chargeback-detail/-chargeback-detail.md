//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[ChargebackDetail](index.md)/[ChargebackDetail](-chargeback-detail.md)

# ChargebackDetail

[JVM]\

public [ChargebackDetail](index.md)[ChargebackDetail](-chargeback-detail.md)([ChargebackDetail.ChargebackStatus](-chargeback-status/index.md)chargebackStatus, [ChargebackDetail.ChargebackReason](-chargeback-reason/index.md)chargebackReason, [Amount](../-amount/index.md)chargebackAmount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankReasonCode, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)chargebackReportedDateTime)

#### Parameters

JVM

| | |
|---|---|
| chargebackStatus | Identifies the chargeback status. Possible values are: -`RECEIVED` - The chargeback was received. -`REVERSAL` - The chargeback reversal was received. |
| chargebackReason | Reason for chargeback which can be `Fraud` or `Non Fraud`. |
| chargebackAmount |
| bankReasonCode | Unique code provided by the acquiring bank for the category of fraud. |
| chargebackReportedDateTime | Date and time when the chargeback was reported to the partner, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
