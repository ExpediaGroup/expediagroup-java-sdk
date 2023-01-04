
# CreditCard

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cardType** | **kotlin.String** | Type of card used for payment, (eg. &#x60;CREDIT&#x60;, &#x60;DEBIT&#x60;). | 
**cardNumber** | **kotlin.String** | All the digits (unencrypted) of the credit card number associated with the payment. | 
**cardAvsResponse** | **kotlin.String** | A field used to confirm if the address provided at the time of purchase matches what the bank has on file for the Credit Card. | 
**cardCvvResponse** | **kotlin.String** | A field used to confirm the Card Verification Value on the Credit Card matches the Credit Card used at the time of purchase. | 
**telephones** | [**kotlin.collections.List&lt;Telephone&gt;**](Telephone.md) | Telephone(s) associated with card holder and credit card. | 
**expiryDate** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Expiration date of the credit card used for payment. |  [optional]
**electronicCommerceIndicator** | **kotlin.String** | Electronic Commerce Indicator, a two or three digit number usually returned by a 3rd party payment processor in regards to the authentication used when gathering the cardholder&#39;s payment credentials. |  [optional]
**virtualCreditCardFlag** | **kotlin.Boolean** | A flag to indicate that the bank card being used for the charge is a virtual credit card. |  [optional]
**walletType** | **kotlin.String** | If a virtual/digital form of payment was used, the type of digital wallet should be specified here. Possible &#x60;wallet_type&#x60;&#39;s include: &#x60;Google&#x60; or &#x60;ApplePay&#x60;. |  [optional]
**merchantOrderCode** | **kotlin.String** | Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. |  [optional]



