//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentSessionsRequestCustomerAccountDetails](index.md)/[PaymentSessionsRequestCustomerAccountDetails](-payment-sessions-request-customer-account-details.md)

# PaymentSessionsRequestCustomerAccountDetails

[JVM]\

public [PaymentSessionsRequestCustomerAccountDetails](index.md)[PaymentSessionsRequestCustomerAccountDetails](-payment-sessions-request-customer-account-details.md)([PaymentSessionsRequestCustomerAccountDetails.AuthenticationMethod](-authentication-method/index.md)authenticationMethod, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)authenticationTimestamp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)createDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changeDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)passwordChangeDate, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)addCardAttempts, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)accountPurchases)

#### Parameters

JVM

| | |
|---|---|
| authenticationMethod | Mechanism used by the cardholder to authenticate to the merchant. |
| authenticationTimestamp | Date and time in UTC of the cardholder authentication, in extended ISO 8601 format. |
| createDate | Date the cardholder opened the account with the merchant, in ISO 8601 format (YYYY-MM-DD). |
| changeDate | Date the cardholder’s account with the merchant was last changed, including Billing or Shipping address, new payment account, or new user(s) added, in ISO 8601 format (YYYY-MM-DD). |
| passwordChangeDate | Date the cardholder’s account with the merchant had a password change or account reset, in ISO 8601 format (YYYY-MM-DD). |
| addCardAttempts | Number of add card attempts in the last 24 hours. |
| accountPurchases | Number of purchases with this cardholder's account during the previous six months. |
