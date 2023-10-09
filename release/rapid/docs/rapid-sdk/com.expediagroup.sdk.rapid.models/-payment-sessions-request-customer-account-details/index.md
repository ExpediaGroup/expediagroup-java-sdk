//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentSessionsRequestCustomerAccountDetails](index.md)

# PaymentSessionsRequestCustomerAccountDetails

public final class [PaymentSessionsRequestCustomerAccountDetails](index.md)

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

## Constructors

| | |
|---|---|
| [PaymentSessionsRequestCustomerAccountDetails](-payment-sessions-request-customer-account-details.md) | [JVM]<br>public [PaymentSessionsRequestCustomerAccountDetails](index.md)[PaymentSessionsRequestCustomerAccountDetails](-payment-sessions-request-customer-account-details.md)([PaymentSessionsRequestCustomerAccountDetails.AuthenticationMethod](-authentication-method/index.md)authenticationMethod, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)authenticationTimestamp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)createDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changeDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)passwordChangeDate, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)addCardAttempts, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)accountPurchases) |

## Types

| Name | Summary |
|---|---|
| [AuthenticationMethod](-authentication-method/index.md) | [JVM]<br>public enum [AuthenticationMethod](-authentication-method/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentSessionsRequestCustomerAccountDetails.AuthenticationMethod](-authentication-method/index.md)&gt;<br>Mechanism used by the cardholder to authenticate to the merchant. Values: GUEST,OWN_CREDENTIALS,FEDERATED_ID,ISSUER_CREDENTIALS,THIRD_PARTY_AUTHENTICATION,FIDO_AUTHENTICATION |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [accountPurchases](index.md#35196081%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[accountPurchases](index.md#35196081%2FProperties%2F700308213) |
| [addCardAttempts](index.md#631466381%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[addCardAttempts](index.md#631466381%2FProperties%2F700308213) |
| [authenticationMethod](index.md#-2095422179%2FProperties%2F700308213) | [JVM]<br>private final [PaymentSessionsRequestCustomerAccountDetails.AuthenticationMethod](-authentication-method/index.md)[authenticationMethod](index.md#-2095422179%2FProperties%2F700308213) |
| [authenticationTimestamp](index.md#-1309975386%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[authenticationTimestamp](index.md#-1309975386%2FProperties%2F700308213) |
| [changeDate](index.md#868085240%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[changeDate](index.md#868085240%2FProperties%2F700308213) |
| [createDate](index.md#-1279691732%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[createDate](index.md#-1279691732%2FProperties%2F700308213) |
| [passwordChangeDate](index.md#3806301%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[passwordChangeDate](index.md#3806301%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentSessionsRequestCustomerAccountDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountPurchases](get-account-purchases.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getAccountPurchases](get-account-purchases.md)() |
| [getAddCardAttempts](get-add-card-attempts.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getAddCardAttempts](get-add-card-attempts.md)() |
| [getAuthenticationMethod](get-authentication-method.md) | [JVM]<br>public final [PaymentSessionsRequestCustomerAccountDetails.AuthenticationMethod](-authentication-method/index.md)[getAuthenticationMethod](get-authentication-method.md)() |
| [getAuthenticationTimestamp](get-authentication-timestamp.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAuthenticationTimestamp](get-authentication-timestamp.md)() |
| [getChangeDate](get-change-date.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getChangeDate](get-change-date.md)() |
| [getCreateDate](get-create-date.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCreateDate](get-create-date.md)() |
| [getPasswordChangeDate](get-password-change-date.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPasswordChangeDate](get-password-change-date.md)() |
