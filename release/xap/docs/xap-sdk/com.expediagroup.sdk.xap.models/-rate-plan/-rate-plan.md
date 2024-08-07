//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RatePlan](index.md)/[RatePlan](-rate-plan.md)

# RatePlan

[JVM]\

public [RatePlan](index.md)[RatePlan](-rate-plan.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomTypeId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ratePlanId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventorySourceId, [StayDates](../-stay-dates/index.md)stayDates, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)remainingCount, [RatePlan.PaymentMethod](-payment-method/index.md)paymentMethod, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rateRuleId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventorySourceCode, [RatePlanPrice](../-rate-plan-price/index.md)price, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberOnlyDeal, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;promotions, [RatePlanStandalonePrice](../-rate-plan-standalone-price/index.md)standalonePrice, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)taxesAndFeesInclusive, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)guaranteeText, [RatePlan.PaymentTime](-payment-time/index.md)paymentTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)fullDepositUponBooking, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentSchedule](../-payment-schedule/index.md)&gt;paymentSchedule, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)reserveWithDeposit, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeInternet, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeWiFi, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;freeInternetDetails, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeParking, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeBreakfast, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;freeBreakfastDetails, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)hcomRewardsEarn, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)hcomRewardsBurn, [CancellationPolicy](../-cancellation-policy/index.md)cancellationPolicy, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanAmenitiesInner](../-rate-plan-amenities-inner/index.md)&gt;amenities)

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
