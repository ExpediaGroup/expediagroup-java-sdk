//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.domain.rapid](../index.md)/[RapidHelpers](index.md)/[extractTransactionId](extract-transaction-id.md)

# extractTransactionId

[JVM]\

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Get transactionId from response headers&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;response.headers[transaction-id]&quot;))

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~extractTransactionId~~](extract-transaction-id.md)&lt;T extends [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(Response&lt;[T](extract-transaction-id.md)&gt;response)

---

### Deprecated

Get transactionId from response headers

#### Replace with

```kotlin
response.headers[transaction-id]
```
---

Extracts the transaction ID from a response object if it exists; otherwise, returns null.
