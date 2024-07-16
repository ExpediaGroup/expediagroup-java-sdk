//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.domain.rapid](../index.md)/[RapidHelpers](index.md)

# RapidHelpers

[JVM]\
@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use operations and responses instead&quot;)

public final class [~~RapidHelpers~~](index.md) extends ClientHelpers---

### Deprecated

Use operations and responses instead

---

## Constructors

| | |
|---|---|
| [RapidHelpers](-rapid-helpers.md) | [JVM]<br>public [RapidHelpers](index.md)[RapidHelpers](-rapid-helpers.md)(BaseRapidClientclient) |

## Functions

| Name | Summary |
|---|---|
| [extractRoomBookingId](extract-room-booking-id.md) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Construct operation using Link&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;Operation(link: Link)&quot;))<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~extractRoomBookingId~~](extract-room-booking-id.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)url)<br>Extracts the room booking ID from a URL string if it exists; otherwise, returns null. |
| [extractToken](extract-token.md) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Construct operation using Link&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;Operation(link: Link)&quot;))<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~extractToken~~](extract-token.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)url)<br>Extracts the token parameter from a URL string if it exists; otherwise, returns null. |
| [extractTransactionId](extract-transaction-id.md) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Get transactionId from response headers&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;response.headers[transaction-id]&quot;))<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~extractTransactionId~~](extract-transaction-id.md)&lt;T extends [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(Response&lt;[T](extract-transaction-id.md)&gt;response)<br>Extracts the transaction ID from a response object if it exists; otherwise, returns null. |
