//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[DepositDetail](index.md)/[DepositDetail](-deposit-detail.md)

# DepositDetail

[JVM]\

public [DepositDetail](index.md)[DepositDetail](-deposit-detail.md)([DepositDetail.Type](-type/index.md)type, [When](../-when/index.md)when, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)

#### Parameters

JVM

| | |
|---|---|
| type | Should be one of the following values: PERCENT The deposit amount is calculated as a percentage of the total booking cost. NIGHT The deposit amount is calculated in terms of nights plus tax. AMOUNT The deposit amount in USD. REMAINDER The deposit amount is equal to the booking cost minus any deposits that have been made before this point. |
|  | `value` Value to indicate how many/much of the type listed above is going to be charged as a deposit. |
