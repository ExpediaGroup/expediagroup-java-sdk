//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RatePlan](index.md)

# RatePlan

public final class [RatePlan](index.md)

Container for information on each rate plan.

#### Parameters

JVM

| | |
|---|---|
| roomTypeId | The room type identifier. |
| ratePlanId | The rate plan identifier. |
| inventorySourceId | The identification number of the source that provides the rate plan. |
| stayDates |
| remainingCount | The number of rooms remaining through Expedia for this room type.  **NOTE**: This value does <u>NOT</u> represent the total number of rooms remaining at the hotel property, only the number of rooms allocated to Expedia for sale by the property that currently remain in Expedia's inventory.  When a hotel is listed as 'sold out' by Expedia there may still be rooms available for sale by the hotel through other channels.  Also note that the `RemainingCount` response element has a maximum returned value of 100, even if there are more than 100 rooms available within bookable Expedia inventory.  **CMA Compliance Note (UK)**: websites in the UK that display `remainingCount` should make it clear to consumers that this count refers to the number of rooms remaining within Expedia inventory - NOT the number remaining at the property. |
| paymentMethod | Room payment information. The available options are: - Online: Pay at the time of booking - Hotel: Could either be paid at the hotel during the time of stay or paid at the time indicated by `PaymentTime` and `PaymentSchedule` |
| rateRuleId | The identifier of rate rule. |
| inventorySourceCode | The source name that provided the rate plan. |
| price |
| memberOnlyDeal | Indicates whether the rate is for member only.  Only visible by configuration. Please contact your Expedia Account Manager if you need this node. |
| promotions | All promotion information of the `ratePlan`. |
| standalonePrice |
| taxesAndFeesInclusive | Indicates whether taxes and fees are included in base rate. |
| guaranteeText | Text description for any deposit information provide by the property (if applicable). |
| paymentTime | The time when the booking amount will be charged on the traveler’s credit card. Valid values are as follows: - UponBooking - PayLater - SupplierDiscretion |
| fullDepositUponBooking | It will be true if PaymentSchedule has one installment and the value of \&quot;Due\&quot; is booking date, otherwise, it will be false. |
| paymentSchedule | Contains information on the payment schedule. |
| reserveWithDeposit | Indicates whether this rate plan need deposit to reserve. |
| freeInternet | Indicates whether the price of the room includes free Internet. (either wireless or wired) |
| freeWiFi | Indicates whether the price of the room includes free wireless Internet access. |
| freeInternetDetails | The localized details for the free internet amenity (only shown when FreeInternet = true).  You can find a link to the complete list of Free Internet Details in [Lodging Free Breakfast and Internet Details](https://developers.expediagroup.com/xap/products/xap/lodging/references/free-breakfast-and-internet-details). |
| freeParking | Indicates whether the price of the room includes free parking. |
| freeBreakfast | Indicates whether the price of the room includes free breakfast. |
| freeBreakfastDetails | The localized details for the free breakfast amenity (only shown when FreeBreakfast = true).  You can find a link to the complete list of Free Breakfast Details in [Lodging Free Breakfast and Internet Details](https://developers.expediagroup.com/xap/products/xap/lodging/references/free-breakfast-and-internet-details). |
| hcomRewardsEarn | Indicate whether the room qualifies for Hcom Rewards Earn. (Hotels.com partners only) |
| hcomRewardsBurn | Indicate whether the room qualifies for Hcom Rewards Burn. (Hotels.com partners only) |
| cancellationPolicy |
| amenities | The amenities of the `rateplan`. |

## Constructors

| | |
|---|---|
| [RatePlan](-rate-plan.md) | [JVM]<br>public [RatePlan](index.md)[RatePlan](-rate-plan.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomTypeId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ratePlanId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventorySourceId, [StayDates](../-stay-dates/index.md)stayDates, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)remainingCount, [RatePlan.PaymentMethod](-payment-method/index.md)paymentMethod, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rateRuleId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventorySourceCode, [RatePlanPrice](../-rate-plan-price/index.md)price, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberOnlyDeal, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;promotions, [RatePlanStandalonePrice](../-rate-plan-standalone-price/index.md)standalonePrice, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)taxesAndFeesInclusive, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)guaranteeText, [RatePlan.PaymentTime](-payment-time/index.md)paymentTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)fullDepositUponBooking, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentSchedule](../-payment-schedule/index.md)&gt;paymentSchedule, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)reserveWithDeposit, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeInternet, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeWiFi, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;freeInternetDetails, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeParking, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeBreakfast, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;freeBreakfastDetails, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)hcomRewardsEarn, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)hcomRewardsBurn, [CancellationPolicy](../-cancellation-policy/index.md)cancellationPolicy, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanAmenitiesInner](../-rate-plan-amenities-inner/index.md)&gt;amenities) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [PaymentMethod](-payment-method/index.md) | [JVM]<br>public enum [PaymentMethod](-payment-method/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RatePlan.PaymentMethod](-payment-method/index.md)&gt;<br>Room payment information. The available options are: - Online: Pay at the time of booking - Hotel: Could either be paid at the hotel during the time of stay or paid at the time indicated by `PaymentTime` and `PaymentSchedule` Values: ONLINE,HOTEL |
| [PaymentTime](-payment-time/index.md) | [JVM]<br>public enum [PaymentTime](-payment-time/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RatePlan.PaymentTime](-payment-time/index.md)&gt;<br>The time when the booking amount will be charged on the traveler’s credit card. Valid values are as follows: - UponBooking - PayLater - SupplierDiscretion Values: UPON_BOOKING,PAY_LATER,SUPPLIER_DISCRETION |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-50579528%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanAmenitiesInner](../-rate-plan-amenities-inner/index.md)&gt;[amenities](index.md#-50579528%2FProperties%2F699445674) |
| [cancellationPolicy](index.md#1055789142%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [CancellationPolicy](../-cancellation-policy/index.md)[cancellationPolicy](index.md#1055789142%2FProperties%2F699445674) |
| [freeBreakfast](index.md#556688896%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[freeBreakfast](index.md#556688896%2FProperties%2F699445674) |
| [freeBreakfastDetails](index.md#-731111368%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[freeBreakfastDetails](index.md#-731111368%2FProperties%2F699445674) |
| [freeInternet](index.md#-960772066%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[freeInternet](index.md#-960772066%2FProperties%2F699445674) |
| [freeInternetDetails](index.md#-1513111462%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[freeInternetDetails](index.md#-1513111462%2FProperties%2F699445674) |
| [freeParking](index.md#-1139210685%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[freeParking](index.md#-1139210685%2FProperties%2F699445674) |
| [freeWiFi](index.md#926748586%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[freeWiFi](index.md#926748586%2FProperties%2F699445674) |
| [fullDepositUponBooking](index.md#706749723%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[fullDepositUponBooking](index.md#706749723%2FProperties%2F699445674) |
| [guaranteeText](index.md#-643997254%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[guaranteeText](index.md#-643997254%2FProperties%2F699445674) |
| [hcomRewardsBurn](index.md#1157647221%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[hcomRewardsBurn](index.md#1157647221%2FProperties%2F699445674) |
| [hcomRewardsEarn](index.md#-258251380%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[hcomRewardsEarn](index.md#-258251380%2FProperties%2F699445674) |
| [inventorySourceCode](index.md#-1588070453%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventorySourceCode](index.md#-1588070453%2FProperties%2F699445674) |
| [inventorySourceId](index.md#-840039651%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventorySourceId](index.md#-840039651%2FProperties%2F699445674) |
| [memberOnlyDeal](index.md#1411598105%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[memberOnlyDeal](index.md#1411598105%2FProperties%2F699445674) |
| [paymentMethod](index.md#2043088712%2FProperties%2F699445674) | [JVM]<br>private final [RatePlan.PaymentMethod](-payment-method/index.md)[paymentMethod](index.md#2043088712%2FProperties%2F699445674) |
| [paymentSchedule](index.md#1102865234%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentSchedule](../-payment-schedule/index.md)&gt;[paymentSchedule](index.md#1102865234%2FProperties%2F699445674) |
| [paymentTime](index.md#1901408732%2FProperties%2F699445674) | [JVM]<br>private final [RatePlan.PaymentTime](-payment-time/index.md)[paymentTime](index.md#1901408732%2FProperties%2F699445674) |
| [price](index.md#-1154924346%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPrice](../-rate-plan-price/index.md)[price](index.md#-1154924346%2FProperties%2F699445674) |
| [promotions](index.md#1635694235%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;[promotions](index.md#1635694235%2FProperties%2F699445674) |
| [ratePlanId](index.md#644860455%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ratePlanId](index.md#644860455%2FProperties%2F699445674) |
| [rateRuleId](index.md#-1519848844%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[rateRuleId](index.md#-1519848844%2FProperties%2F699445674) |
| [remainingCount](index.md#-1541269710%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[remainingCount](index.md#-1541269710%2FProperties%2F699445674) |
| [reserveWithDeposit](index.md#2108699055%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[reserveWithDeposit](index.md#2108699055%2FProperties%2F699445674) |
| [roomTypeId](index.md#-1691037669%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[roomTypeId](index.md#-1691037669%2FProperties%2F699445674) |
| [standalonePrice](index.md#-716042261%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanStandalonePrice](../-rate-plan-standalone-price/index.md)[standalonePrice](index.md#-716042261%2FProperties%2F699445674) |
| [stayDates](index.md#-1367978301%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [StayDates](../-stay-dates/index.md)[stayDates](index.md#-1367978301%2FProperties%2F699445674) |
| [taxesAndFeesInclusive](index.md#413759278%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[taxesAndFeesInclusive](index.md#413759278%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RatePlan.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanAmenitiesInner](../-rate-plan-amenities-inner/index.md)&gt;[getAmenities](get-amenities.md)() |
| [getCancellationPolicy](get-cancellation-policy.md) | [JVM]<br>public final [CancellationPolicy](../-cancellation-policy/index.md)[getCancellationPolicy](get-cancellation-policy.md)() |
| [getFreeBreakfast](get-free-breakfast.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFreeBreakfast](get-free-breakfast.md)() |
| [getFreeBreakfastDetails](get-free-breakfast-details.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getFreeBreakfastDetails](get-free-breakfast-details.md)() |
| [getFreeInternet](get-free-internet.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFreeInternet](get-free-internet.md)() |
| [getFreeInternetDetails](get-free-internet-details.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getFreeInternetDetails](get-free-internet-details.md)() |
| [getFreeParking](get-free-parking.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFreeParking](get-free-parking.md)() |
| [getFreeWiFi](get-free-wi-fi.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFreeWiFi](get-free-wi-fi.md)() |
| [getFullDepositUponBooking](get-full-deposit-upon-booking.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFullDepositUponBooking](get-full-deposit-upon-booking.md)() |
| [getGuaranteeText](get-guarantee-text.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGuaranteeText](get-guarantee-text.md)() |
| [getHcomRewardsBurn](get-hcom-rewards-burn.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getHcomRewardsBurn](get-hcom-rewards-burn.md)() |
| [getHcomRewardsEarn](get-hcom-rewards-earn.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getHcomRewardsEarn](get-hcom-rewards-earn.md)() |
| [getInventorySourceCode](get-inventory-source-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventorySourceCode](get-inventory-source-code.md)() |
| [getInventorySourceId](get-inventory-source-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventorySourceId](get-inventory-source-id.md)() |
| [getMemberOnlyDeal](get-member-only-deal.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMemberOnlyDeal](get-member-only-deal.md)() |
| [getPaymentMethod](get-payment-method.md) | [JVM]<br>public final [RatePlan.PaymentMethod](-payment-method/index.md)[getPaymentMethod](get-payment-method.md)() |
| [getPaymentSchedule](get-payment-schedule.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentSchedule](../-payment-schedule/index.md)&gt;[getPaymentSchedule](get-payment-schedule.md)() |
| [getPaymentTime](get-payment-time.md) | [JVM]<br>public final [RatePlan.PaymentTime](-payment-time/index.md)[getPaymentTime](get-payment-time.md)() |
| [getPrice](get-price.md) | [JVM]<br>public final [RatePlanPrice](../-rate-plan-price/index.md)[getPrice](get-price.md)() |
| [getPromotions](get-promotions.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;[getPromotions](get-promotions.md)() |
| [getRatePlanId](get-rate-plan-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRatePlanId](get-rate-plan-id.md)() |
| [getRateRuleId](get-rate-rule-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRateRuleId](get-rate-rule-id.md)() |
| [getRemainingCount](get-remaining-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRemainingCount](get-remaining-count.md)() |
| [getReserveWithDeposit](get-reserve-with-deposit.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getReserveWithDeposit](get-reserve-with-deposit.md)() |
| [getRoomTypeId](get-room-type-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRoomTypeId](get-room-type-id.md)() |
| [getStandalonePrice](get-standalone-price.md) | [JVM]<br>public final [RatePlanStandalonePrice](../-rate-plan-standalone-price/index.md)[getStandalonePrice](get-standalone-price.md)() |
| [getStayDates](get-stay-dates.md) | [JVM]<br>public final [StayDates](../-stay-dates/index.md)[getStayDates](get-stay-dates.md)() |
| [getTaxesAndFeesInclusive](get-taxes-and-fees-inclusive.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getTaxesAndFeesInclusive](get-taxes-and-fees-inclusive.md)() |
