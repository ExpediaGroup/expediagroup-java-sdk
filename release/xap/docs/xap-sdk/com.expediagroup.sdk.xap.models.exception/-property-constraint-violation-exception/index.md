//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models.exception](../index.md)/[PropertyConstraintViolationException](index.md)

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
| [constraintViolations](index.md#281743026%2FProperties%2F699445674) | [JVM]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyConstraintViolation](../-property-constraint-violation/index.md)&gt;[constraintViolations](index.md#281743026%2FProperties%2F699445674)<br>A list of the constraint violations that occurred |

## Functions

| Name | Summary |
|---|---|
| [getConstraintViolations](get-constraint-violations.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyConstraintViolation](../-property-constraint-violation/index.md)&gt;[getConstraintViolations](get-constraint-violations.md)()<br>A list of the constraint violations that occurred |
