# FraudPreventionClient

All URIs are relative to *https://api.expediagroup.com/test/fraud-prevention*

Method | HTTP request | Description
------------- | ------------- | -------------
[**screen**](FraudPreventionClient.md#screen) | **POST** /fraud-prevention/order/purchase/screen | Run fraud screening for one transaction
[**update**](FraudPreventionClient.md#update) | **POST** /fraud-prevention/order/purchase/update | Send an update for a transaction


<a name="screen"></a>
# **screen**
> OrderPurchaseScreenResponse screen(orderPurchaseScreenRequest)

Run fraud screening for one transaction

The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously. 

### Example
```kotlin
// Import classes:
//import com.expediagroup.openworld.sdk.fraudprevention.infrastructure.*
//import com.expediagroup.openworld.sdk.fraudprevention.models.*

val apiInstance = FraudPreventionClient()
val orderPurchaseScreenRequest : OrderPurchaseScreenRequest =  // OrderPurchaseScreenRequest | 
try {
    val result : OrderPurchaseScreenResponse = apiInstance.screen(orderPurchaseScreenRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FraudPreventionClient#screen")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FraudPreventionClient#screen")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderPurchaseScreenRequest** | [**OrderPurchaseScreenRequest**](OrderPurchaseScreenRequest.md)|  |

### Return type

[**OrderPurchaseScreenResponse**](OrderPurchaseScreenResponse.md)

### Authorization


Configure orderPurchaseScreenAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="update"></a>
# **update**
> update(orderPurchaseUpdateRequest)

Send an update for a transaction

The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation. 

### Example
```kotlin
// Import classes:
//import com.expediagroup.openworld.sdk.fraudprevention.infrastructure.*
//import com.expediagroup.openworld.sdk.fraudprevention.models.*

val apiInstance = FraudPreventionClient()
val orderPurchaseUpdateRequest : OrderPurchaseUpdateRequest = {"type":"ORDER_UPDATE","risk_id":"1234324324","order_status":"COMPLETED","cancellation_reason":{"primary_reason_description":"string"}} // OrderPurchaseUpdateRequest | An OrderPurchaseUpdate request may be of one of the following types `ORDER_UPDATE`, `CHARGEBACK_FEEDBACK`, `INSULT_FEEDBACK`, `REFUND_UPDATE`, `PAYMENT_UPDATE`. 
try {
    apiInstance.update(orderPurchaseUpdateRequest)
} catch (e: ClientException) {
    println("4xx response calling FraudPreventionClient#update")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FraudPreventionClient#update")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderPurchaseUpdateRequest** | [**OrderPurchaseUpdateRequest**](OrderPurchaseUpdateRequest.md)| An OrderPurchaseUpdate request may be of one of the following types &#x60;ORDER_UPDATE&#x60;, &#x60;CHARGEBACK_FEEDBACK&#x60;, &#x60;INSULT_FEEDBACK&#x60;, &#x60;REFUND_UPDATE&#x60;, &#x60;PAYMENT_UPDATE&#x60;.  |

### Return type

null (empty response body)

### Authorization


Configure orderPurchaseUpdateAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

