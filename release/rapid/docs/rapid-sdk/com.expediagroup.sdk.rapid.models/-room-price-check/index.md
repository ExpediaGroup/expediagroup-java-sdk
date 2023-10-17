//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomPriceCheck](index.md)

# RoomPriceCheck

public final class [RoomPriceCheck](index.md)

The price check response.

#### Parameters

JVM

| |
|---|
| status |
| occupancyPricing | A map of room information by occupancy. |
| links |
| cardOnFileLimit |
| refundableDamageDeposit |
| deposits | Array of deposits. |
| refund |
| amountOwed |
| penalty |
| traderInformation |

## Constructors

| | |
|---|---|
| [RoomPriceCheck](-room-price-check.md) | [JVM]<br>public [RoomPriceCheck](index.md)[RoomPriceCheck](-room-price-check.md)([StatusPriceCheck](../-status-price-check/index.md)status, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;occupancyPricing, [RoomPriceCheckLinks](../-room-price-check-links/index.md)links, [Amount](../-amount/index.md)cardOnFileLimit, [Amount](../-amount/index.md)refundableDamageDeposit, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;deposits, [Charge](../-charge/index.md)refund, [Charge](../-charge/index.md)amountOwed, [Charge](../-charge/index.md)penalty, [TraderInformation](../-trader-information/index.md)traderInformation) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amountOwed](index.md#2008057362%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[amountOwed](index.md#2008057362%2FProperties%2F700308213) |
| [cardOnFileLimit](index.md#-744463239%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[cardOnFileLimit](index.md#-744463239%2FProperties%2F700308213) |
| [deposits](index.md#-1143135428%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;[deposits](index.md#-1143135428%2FProperties%2F700308213) |
| [links](index.md#238411568%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [RoomPriceCheckLinks](../-room-price-check-links/index.md)[links](index.md#238411568%2FProperties%2F700308213) |
| [occupancyPricing](index.md#2128000664%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;[occupancyPricing](index.md#2128000664%2FProperties%2F700308213) |
| [penalty](index.md#-498045600%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[penalty](index.md#-498045600%2FProperties%2F700308213) |
| [refund](index.md#1945969593%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[refund](index.md#1945969593%2FProperties%2F700308213) |
| [refundableDamageDeposit](index.md#-138947604%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[refundableDamageDeposit](index.md#-138947604%2FProperties%2F700308213) |
| [status](index.md#-2137599873%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [StatusPriceCheck](../-status-price-check/index.md)[status](index.md#-2137599873%2FProperties%2F700308213) |
| [traderInformation](index.md#-1411219509%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [TraderInformation](../-trader-information/index.md)[traderInformation](index.md#-1411219509%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomPriceCheck.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmountOwed](get-amount-owed.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getAmountOwed](get-amount-owed.md)() |
| [getCardOnFileLimit](get-card-on-file-limit.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getCardOnFileLimit](get-card-on-file-limit.md)() |
| [getDeposits](get-deposits.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;[getDeposits](get-deposits.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [RoomPriceCheckLinks](../-room-price-check-links/index.md)[getLinks](get-links.md)() |
| [getOccupancyPricing](get-occupancy-pricing.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;[getOccupancyPricing](get-occupancy-pricing.md)() |
| [getPenalty](get-penalty.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getPenalty](get-penalty.md)() |
| [getRefund](get-refund.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getRefund](get-refund.md)() |
| [getRefundableDamageDeposit](get-refundable-damage-deposit.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getRefundableDamageDeposit](get-refundable-damage-deposit.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [StatusPriceCheck](../-status-price-check/index.md)[getStatus](get-status.md)() |
| [getTraderInformation](get-trader-information.md) | [JVM]<br>public final [TraderInformation](../-trader-information/index.md)[getTraderInformation](get-trader-information.md)() |
