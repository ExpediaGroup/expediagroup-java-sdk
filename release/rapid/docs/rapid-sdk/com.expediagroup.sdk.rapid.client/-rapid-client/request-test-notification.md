//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[requestTestNotification](request-test-notification.md)

# requestTestNotification

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[requestTestNotification](request-test-notification.md)([TestNotificationRequest](../../com.expediagroup.sdk.rapid.models/-test-notification-request/index.md)testNotificationRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[requestTestNotification](request-test-notification.md)([TestNotificationRequest](../../com.expediagroup.sdk.rapid.models/-test-notification-request/index.md)testNotificationRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[requestTestNotification](request-test-notification.md)([TestNotificationRequest](../../com.expediagroup.sdk.rapid.models/-test-notification-request/index.md)testNotificationRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[requestTestNotification](request-test-notification.md)([TestNotificationRequest](../../com.expediagroup.sdk.rapid.models/-test-notification-request/index.md)testNotificationRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[requestTestNotification](request-test-notification.md)([TestNotificationRequest](../../com.expediagroup.sdk.rapid.models/-test-notification-request/index.md)testNotificationRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[requestTestNotification](request-test-notification.md)([TestNotificationRequest](../../com.expediagroup.sdk.rapid.models/-test-notification-request/index.md)testNotificationRequest)

Request Test Notification This request triggers a test notification according to the specified event_type. All event types supported by the Notifications API are available to test.

#### Return

Nothing

#### Parameters

JVM

| | |
|---|---|
| billingTerms | This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately.  (optional) |
| partnerPointOfSale | This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately.  (optional) |
| paymentTerms | This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately.  (optional) |
| platformName | This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately.  (optional) |
| testNotificationRequest |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
