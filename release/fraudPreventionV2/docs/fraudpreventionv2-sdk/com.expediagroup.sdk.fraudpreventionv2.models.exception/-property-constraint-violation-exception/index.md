//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models.exception](../index.md)/[PropertyConstraintViolationException](index.md)

# PropertyConstraintViolationException

[JVM]\
public final class [PropertyConstraintViolationException](index.md) extends ExpediaGroupClientException

An exception to be thrown when a constraint on some property has been violated.

## Constructors

| | |
|---|---|
| [PropertyConstraintViolationException](-property-constraint-violation-exception.md) | [JVM]<br>public [PropertyConstraintViolationException](index.md)[PropertyConstraintViolationException](-property-constraint-violation-exception.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyConstraintViolation](../-property-constraint-violation/index.md)&gt;constraintViolations) |

## Properties

| Name | Summary |
|---|---|
| [cause](index.md#-654012527%2FProperties%2F-173342751) | [JVM]<br>private final [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)[cause](index.md#-654012527%2FProperties%2F-173342751) |
| [constraintViolations](index.md#894591771%2FProperties%2F-173342751) | [JVM]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyConstraintViolation](../-property-constraint-violation/index.md)&gt;[constraintViolations](index.md#894591771%2FProperties%2F-173342751)<br>A list of the constraint violations that occurred |
| [message](index.md#1824300659%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#1824300659%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [addSuppressed](index.md#282858770%2FFunctions%2F-173342751) | [JVM]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[addSuppressed](index.md#282858770%2FFunctions%2F-173342751)([Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)p0) |
| [fillInStackTrace](index.md#-1102069925%2FFunctions%2F-173342751) | [JVM]<br>public [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)[fillInStackTrace](index.md#-1102069925%2FFunctions%2F-173342751)() |
| [getCause](index.md#-1113108691%2FFunctions%2F-173342751) | [JVM]<br>public [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)[getCause](index.md#-1113108691%2FFunctions%2F-173342751)() |
| [getConstraintViolations](get-constraint-violations.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyConstraintViolation](../-property-constraint-violation/index.md)&gt;[getConstraintViolations](get-constraint-violations.md)()<br>A list of the constraint violations that occurred |
| [getLocalizedMessage](index.md#1043865560%2FFunctions%2F-173342751) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLocalizedMessage](index.md#1043865560%2FFunctions%2F-173342751)() |
| [getMessage](index.md#-1280448753%2FFunctions%2F-173342751) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](index.md#-1280448753%2FFunctions%2F-173342751)() |
| [getStackTrace](index.md#2050903719%2FFunctions%2F-173342751) | [JVM]<br>public [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://docs.oracle.com/javase/8/docs/api/java/lang/StackTraceElement.html)&gt;[getStackTrace](index.md#2050903719%2FFunctions%2F-173342751)() |
| [getSuppressed](index.md#672492560%2FFunctions%2F-173342751) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)&gt;[getSuppressed](index.md#672492560%2FFunctions%2F-173342751)() |
| [initCause](index.md#-418225042%2FFunctions%2F-173342751) | [JVM]<br>public [Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)[initCause](index.md#-418225042%2FFunctions%2F-173342751)([Throwable](https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html)p0) |
| [printStackTrace](index.md#-1769529168%2FFunctions%2F-173342751) | [JVM]<br>public [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[printStackTrace](index.md#-1769529168%2FFunctions%2F-173342751)()<br>public [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[printStackTrace](index.md#1841853697%2FFunctions%2F-173342751)([PrintStream](https://docs.oracle.com/javase/8/docs/api/java/io/PrintStream.html)p0)<br>public [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[printStackTrace](index.md#1175535278%2FFunctions%2F-173342751)([PrintWriter](https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html)p0) |
| [setStackTrace](index.md#2135801318%2FFunctions%2F-173342751) | [JVM]<br>public [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[setStackTrace](index.md#2135801318%2FFunctions%2F-173342751)([Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://docs.oracle.com/javase/8/docs/api/java/lang/StackTraceElement.html)&gt;p0) |
