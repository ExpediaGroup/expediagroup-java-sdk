//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[ValidFormsOfPayment](index.md)

# ValidFormsOfPayment

public final class [ValidFormsOfPayment](index.md)

Container for hotel supported payment information.

#### Parameters

JVM

| | |
|---|---|
| paymentMethod | The payment method. |
| name | The brand name of the payment sub-method to be displayed to the customer. |
| paymentSubMethod | The payment sub-method. |
| brandName | The brand name of the payment sub-method to be displayed to the customer.  In many cases it will be the same as the payment sub-method, but \&quot;Visa/Carte Blanche\&quot; and \&quot;Visa/Delta\&quot; are some of the exceptions. |

## Constructors

| | |
|---|---|
| [ValidFormsOfPayment](-valid-forms-of-payment.md) | [JVM]<br>public [ValidFormsOfPayment](index.md)[ValidFormsOfPayment](-valid-forms-of-payment.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentMethod, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentSubMethod, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)brandName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [brandName](index.md#-1988386990%2FProperties%2F699445674) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;This property is deprecated.&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~brandName~~](index.md#-1988386990%2FProperties%2F699445674) |
| [name](index.md#1137317163%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#1137317163%2FProperties%2F699445674) |
| [paymentMethod](index.md#-211150435%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[paymentMethod](index.md#-211150435%2FProperties%2F699445674) |
| [paymentSubMethod](index.md#1058597979%2FProperties%2F699445674) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;This property is deprecated.&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~paymentSubMethod~~](index.md#1058597979%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ValidFormsOfPayment.Builder](-builder/index.md)[builder](builder.md)() |
| [getBrandName](get-brand-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBrandName](get-brand-name.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getPaymentMethod](get-payment-method.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaymentMethod](get-payment-method.md)() |
| [getPaymentSubMethod](get-payment-sub-method.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaymentSubMethod](get-payment-sub-method.md)() |
