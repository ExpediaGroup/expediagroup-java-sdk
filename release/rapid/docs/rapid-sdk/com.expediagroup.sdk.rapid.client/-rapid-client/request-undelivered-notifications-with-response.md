//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[requestUndeliveredNotificationsWithResponse](request-undelivered-notifications-with-response.md)

# requestUndeliveredNotificationsWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Notification](../../com.expediagroup.sdk.rapid.models/-notification/index.md)&gt;&gt;[requestUndeliveredNotificationsWithResponse](request-undelivered-notifications-with-response.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)undeliverable, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Notification](../../com.expediagroup.sdk.rapid.models/-notification/index.md)&gt;&gt;[requestUndeliveredNotificationsWithResponse](request-undelivered-notifications-with-response.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)undeliverable, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Notification](../../com.expediagroup.sdk.rapid.models/-notification/index.md)&gt;&gt;[requestUndeliveredNotificationsWithResponse](request-undelivered-notifications-with-response.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)undeliverable, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Notification](../../com.expediagroup.sdk.rapid.models/-notification/index.md)&gt;&gt;[requestUndeliveredNotificationsWithResponse](request-undelivered-notifications-with-response.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)undeliverable, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Notification](../../com.expediagroup.sdk.rapid.models/-notification/index.md)&gt;&gt;[requestUndeliveredNotificationsWithResponse](request-undelivered-notifications-with-response.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)undeliverable)

Request Undelivered Notifications Use this API to fetch undelivered notifications. Up to 25 notifications are returned with each call. Each undelivered notification will be returned only once.

#### Return

a Response object with a body of type kotlin.collections.List<Notification>

#### Parameters

JVM

| | |
|---|---|
| undeliverable | Undeliverable notifications are returned when this parameter is set to `true`. |
| billingTerms | This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately.  (optional) |
| partnerPointOfSale | This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately.  (optional) |
| paymentTerms | This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately.  (optional) |
| platformName | This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately.  (optional) |
