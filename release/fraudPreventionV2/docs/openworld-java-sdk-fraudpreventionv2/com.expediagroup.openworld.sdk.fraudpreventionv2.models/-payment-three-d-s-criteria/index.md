//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[PaymentThreeDSCriteria](index.md)

# PaymentThreeDSCriteria

public final class [PaymentThreeDSCriteria](index.md)

Payment ThreeDS criteria attributes.

#### Parameters

JVM

| | |
|---|---|
| probableFlag | This is a flag passed that indicates that this transaction could potentially go through 3DS. |
| transactionModel | Model used to process payment transaction. |

## Constructors

| | |
|---|---|
| [PaymentThreeDSCriteria](-payment-three-d-s-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](index.md)[PaymentThreeDSCriteria](-payment-three-d-s-criteria.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)probableFlag, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionModel) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentThreeDSCriteria.Builder](-builder/index.md)[builder](builder.md)() |
| [getProbableFlag](get-probable-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getProbableFlag](get-probable-flag.md)() |
| [getTransactionModel](get-transaction-model.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionModel](get-transaction-model.md)() |

## Properties

| Name | Summary |
|---|---|
| [probableFlag](index.md#1741337040%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[probableFlag](index.md#1741337040%2FProperties%2F-1883119931) |
| [transactionModel](index.md#-787797984%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionModel](index.md#-787797984%2FProperties%2F-1883119931) |
