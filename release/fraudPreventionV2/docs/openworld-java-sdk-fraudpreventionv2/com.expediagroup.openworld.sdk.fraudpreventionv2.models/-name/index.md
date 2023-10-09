//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Name](index.md)

# Name

public final class [Name](index.md)

Group of attributes intended to hold information about a customer or traveler's name for the order.

#### Parameters

JVM

| | |
|---|---|
| lastName | Surname, or last name, of the person. |
| firstName | Given, or first name, of the person. |
| middleName | Middle name of the person. |
| title | Title of the person for name (e.g. Mr., Ms. etc). |
| suffix | Generational designations (e.g. Sr, Jr, III) or values that indicate the individual holds a position, educational degree, accreditation, office, or honor (e.g. PhD, CCNA, OBE). |

## Constructors

| | |
|---|---|
| [Name](-name.md) | [JVM]<br>public [Name](index.md)[Name](-name.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)lastName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)firstName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)middleName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)title, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)suffix) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Name.Builder](-builder/index.md)[builder](builder.md)() |
| [getFirstName](get-first-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFirstName](get-first-name.md)() |
| [getLastName](get-last-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLastName](get-last-name.md)() |
| [getMiddleName](get-middle-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMiddleName](get-middle-name.md)() |
| [getSuffix](get-suffix.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSuffix](get-suffix.md)() |
| [getTitle](get-title.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTitle](get-title.md)() |

## Properties

| Name | Summary |
|---|---|
| [firstName](index.md#223992687%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[firstName](index.md#223992687%2FProperties%2F-1883119931) |
| [lastName](index.md#-1057752497%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[lastName](index.md#-1057752497%2FProperties%2F-1883119931) |
| [middleName](index.md#-1397569808%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[middleName](index.md#-1397569808%2FProperties%2F-1883119931) |
| [suffix](index.md#-887133185%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[suffix](index.md#-887133185%2FProperties%2F-1883119931) |
| [title](index.md#-630315118%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[title](index.md#-630315118%2FProperties%2F-1883119931) |
