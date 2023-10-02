//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[Paginator](index.md)

# Paginator

[JVM]\
public final class [Paginator](index.md)&lt;T extends [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)&gt; implements [Iterator](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)&lt;[T](index.md)&gt;

## Constructors

| | |
|---|---|
| [Paginator](-paginator.md) | [JVM]<br>public [Paginator](index.md)&lt;[T](index.md)&gt;[Paginator](-paginator.md)&lt;T extends [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;([RapidClient](../-rapid-client/index.md)client, [Response](../-response/index.md)&lt;[T](index.md)&gt;firstResponse, [SuspendFunction1](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-suspend-function1/index.html)&lt;HttpResponse, [T](index.md)&gt;getBody) |

## Properties

| Name | Summary |
|---|---|
| [paginationTotalResults](index.md#-1523829013%2FProperties%2F700308213) | [JVM]<br>private final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[paginationTotalResults](index.md#-1523829013%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [forEachRemaining](index.md#-511368593%2FFunctions%2F700308213) | [JVM]<br>public [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[forEachRemaining](index.md#-511368593%2FFunctions%2F700308213)([Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)&lt;? super [T](index.md)&gt;p0) |
| [getPaginationTotalResults](get-pagination-total-results.md) | [JVM]<br>public final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[getPaginationTotalResults](get-pagination-total-results.md)() |
| [hasNext](has-next.md) | [JVM]<br>public [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[hasNext](has-next.md)() |
| [next](next.md) | [JVM]<br>public [T](index.md)[next](next.md)() |
