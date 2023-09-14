//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[CustomerAccount](index.md)/[CustomerAccount](-customer-account.md)

# CustomerAccount

[JVM]\

public [CustomerAccount](index.md)[CustomerAccount](-customer-account.md)([CustomerAccount.AccountType](-account-type/index.md)accountType, [Name](../-name/index.md)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)userId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [CustomerAccountAddress](../-customer-account-address/index.md)address, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)registeredTime)

#### Parameters

JVM

| | |
|---|---|
| accountType | Identifies if the customer account is known to the client. Possible values are:  -`GUEST` - Applicable if the partner maintains record to distinguish whether the transaction was booked via a guest account.  -`STANDARD` - Default account type. |
| name |
| emailAddress | Email address for the account owner. |
| userId | Unique account identifier provided by the partner's Identity Provider/System assigned to the account owner by the partner. `user_id` is specific to the partner namespace. Used to track repeat purchases by the same user. |
| telephones |
| address |
| registeredTime | The local date and time that the customer first registered on the client site, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
