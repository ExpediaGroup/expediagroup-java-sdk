//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[AccountTransaction](index.md)

# AccountTransaction

public final class [AccountTransaction](index.md)

Information for an account transaction.

#### Parameters

JVM

| |
|---|
| siteInfo |
| deviceDetails |
| customerAccount |
| transactionDetails |

## Constructors

| | |
|---|---|
| [AccountTransaction](-account-transaction.md) | [JVM]<br>public [AccountTransaction](index.md)[AccountTransaction](-account-transaction.md)([AccountTakeoverSiteInfo](../-account-takeover-site-info/index.md)siteInfo, [AccountTakeoverDeviceDetails](../-account-takeover-device-details/index.md)deviceDetails, [AccountTakeoverCustomerAccount](../-account-takeover-customer-account/index.md)customerAccount, [AccountTakeoverTransactionDetails](../-account-takeover-transaction-details/index.md)transactionDetails) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountTransaction.Builder](-builder/index.md)[builder](builder.md)() |
| [getCustomerAccount](get-customer-account.md) | [JVM]<br>public final [AccountTakeoverCustomerAccount](../-account-takeover-customer-account/index.md)[getCustomerAccount](get-customer-account.md)() |
| [getDeviceDetails](get-device-details.md) | [JVM]<br>public final [AccountTakeoverDeviceDetails](../-account-takeover-device-details/index.md)[getDeviceDetails](get-device-details.md)() |
| [getSiteInfo](get-site-info.md) | [JVM]<br>public final [AccountTakeoverSiteInfo](../-account-takeover-site-info/index.md)[getSiteInfo](get-site-info.md)() |
| [getTransactionDetails](get-transaction-details.md) | [JVM]<br>public final [AccountTakeoverTransactionDetails](../-account-takeover-transaction-details/index.md)[getTransactionDetails](get-transaction-details.md)() |

## Properties

| Name | Summary |
|---|---|
| [customerAccount](index.md#-1523333067%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [AccountTakeoverCustomerAccount](../-account-takeover-customer-account/index.md)[customerAccount](index.md#-1523333067%2FProperties%2F-1883119931) |
| [deviceDetails](index.md#-1846491656%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [AccountTakeoverDeviceDetails](../-account-takeover-device-details/index.md)[deviceDetails](index.md#-1846491656%2FProperties%2F-1883119931) |
| [siteInfo](index.md#524692641%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [AccountTakeoverSiteInfo](../-account-takeover-site-info/index.md)[siteInfo](index.md#524692641%2FProperties%2F-1883119931) |
| [transactionDetails](index.md#-1866766510%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [AccountTakeoverTransactionDetails](../-account-takeover-transaction-details/index.md)[transactionDetails](index.md#-1866766510%2FProperties%2F-1883119931) |
