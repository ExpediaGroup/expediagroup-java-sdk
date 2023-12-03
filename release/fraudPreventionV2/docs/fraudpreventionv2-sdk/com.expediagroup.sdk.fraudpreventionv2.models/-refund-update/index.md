//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[RefundUpdate](index.md)

# RefundUpdate

public interface [RefundUpdate](index.md) implements [OrderPurchaseUpdateRequest](../-order-purchase-update-request/index.md)

Refund related data. Update should be sent when refund is issued or settled. Amounts should include all fees and taxes.

#### Parameters

JVM

| | |
|---|---|
| refundStatus | Identifies the refund status. Possible values are: -`ISSUED` - The refund was issued. -`SETTLED` - The refund was settled. |

#### Inheritors

| |
|---|
| [IssuedRefundUpdate](../-issued-refund-update/index.md) |
| [SettledRefundUpdate](../-settled-refund-update/index.md) |

## Types

| Name | Summary |
|---|---|
| [RefundStatus](-refund-status/index.md) | [JVM]<br>public enum [RefundStatus](-refund-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RefundUpdate.RefundStatus](-refund-status/index.md)&gt;<br>Identifies the refund status. Possible values are: -`ISSUED` - The refund was issued. -`SETTLED` - The refund was settled. Values: ISSUED,SETTLED |

## Functions

| Name | Summary |
|---|---|
| [getRefundStatus](get-refund-status.md) | [JVM]<br>public abstract [RefundUpdate.RefundStatus](-refund-status/index.md)[getRefundStatus](get-refund-status.md)() |
