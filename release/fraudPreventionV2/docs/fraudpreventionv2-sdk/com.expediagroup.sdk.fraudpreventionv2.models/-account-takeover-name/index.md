//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverName](index.md)

# AccountTakeoverName

public final class [AccountTakeoverName](index.md)

Group of attributes intended to hold information about a customer or traveler''s name for the account.

#### Parameters

JVM

| | |
|---|---|
| lastName | Surname, or last name, of the person. |
| firstName | Given, or first name, of the person. |
| middleName | Middle name of the person. |
| title | Title of the person for name (e.g. Mr., Ms. etc). |
| suffix | Generational designations (e.g. Sr, Jr, III) or values indicate that the individual holds a position, educational degree, accreditation, office, or honor (e.g. PhD, CCNA, OBE). |

## Constructors

| | |
|---|---|
| [AccountTakeoverName](-account-takeover-name.md) | [JVM]<br>public [AccountTakeoverName](index.md)[AccountTakeoverName](-account-takeover-name.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)lastName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)firstName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)middleName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)title, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)suffix) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [firstName](index.md#1196665499%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[firstName](index.md#1196665499%2FProperties%2F-173342751) |
| [lastName](index.md#774739363%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[lastName](index.md#774739363%2FProperties%2F-173342751) |
| [middleName](index.md#-1309483708%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[middleName](index.md#-1309483708%2FProperties%2F-173342751) |
| [suffix](index.md#-353383341%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[suffix](index.md#-353383341%2FProperties%2F-173342751) |
| [title](index.md#-1582928706%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[title](index.md#-1582928706%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountTakeoverName.Builder](-builder/index.md)[builder](builder.md)() |
| [getFirstName](get-first-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFirstName](get-first-name.md)() |
| [getLastName](get-last-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLastName](get-last-name.md)() |
| [getMiddleName](get-middle-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMiddleName](get-middle-name.md)() |
| [getSuffix](get-suffix.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSuffix](get-suffix.md)() |
| [getTitle](get-title.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTitle](get-title.md)() |
