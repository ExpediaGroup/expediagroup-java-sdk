//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Ticket](index.md)

# Ticket

public final class [Ticket](index.md)

#### Parameters

JVM

| | |
|---|---|
| type | Specifies the type of the ticket, such as ADULT, CHILD, SENIOR, STUDENT, or OTHER. |
| quantity | This field represents the count or number of tickets associated with the type. |

## Constructors

| | |
|---|---|
| [Ticket](-ticket.md) | [JVM]<br>public [Ticket](index.md)[Ticket](-ticket.md)([Ticket.Type](-type/index.md)type, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)quantity) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Ticket.Type](-type/index.md)&gt;<br>Specifies the type of the ticket, such as ADULT, CHILD, SENIOR, STUDENT, or OTHER. Values: ADULT,CHILD,SENIOR,STUDENT,OTHER |

## Properties

| Name | Summary |
|---|---|
| [quantity](index.md#859008044%2FProperties%2F-173342751) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[quantity](index.md#859008044%2FProperties%2F-173342751) |
| [type](index.md#598323549%2FProperties%2F-173342751) | [JVM]<br>private final [Ticket.Type](-type/index.md)[type](index.md#598323549%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Ticket.Builder](-builder/index.md)[builder](builder.md)() |
| [getQuantity](get-quantity.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getQuantity](get-quantity.md)() |
| [getType](get-type.md) | [JVM]<br>public final [Ticket.Type](-type/index.md)[getType](get-type.md)() |
