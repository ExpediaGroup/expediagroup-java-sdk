//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.domain.rapid](../index.md)/[RapidHelpers](index.md)

# RapidHelpers

[JVM]\
public final class [RapidHelpers](index.md) extends ClientHelpers

## Constructors

| | |
|---|---|
| [RapidHelpers](-rapid-helpers.md) | [JVM]<br>public [RapidHelpers](index.md)[RapidHelpers](-rapid-helpers.md)(BaseRapidClientclient) |

## Functions

| Name | Summary |
|---|---|
| [extractRoomBookingId](extract-room-booking-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[extractRoomBookingId](extract-room-booking-id.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)url)<br>Extracts the room booking ID from a URL string if it exists; otherwise, returns null. |
| [extractToken](extract-token.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[extractToken](extract-token.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)url)<br>Extracts the token parameter from a URL string if it exists; otherwise, returns null. |
| [extractTransactionId](extract-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[extractTransactionId](extract-transaction-id.md)&lt;T extends [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(Response&lt;[T](extract-transaction-id.md)&gt;response)<br>Extracts the transaction ID from a response object if it exists; otherwise, returns null. |
