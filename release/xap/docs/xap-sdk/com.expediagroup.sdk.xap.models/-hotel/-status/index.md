//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.models](../../index.md)/[Hotel](../index.md)/[Status](index.md)

# Status

[JVM]\
public enum [Status](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Hotel.Status](index.md)&gt;

Indicates whether there are available offers at the property during the dates requested, as well as information as to why.  Note that pricing will <u>only</u> be present in the API response for a status of `AVAILABLE`.  If there are no rooms available at the property for the dates requested, then `NOT_AVAILABLE` will be returned.  If there are available rooms, but none that meet the specific parameters of the search request, then one of the other messages will be returned. Values: AVAILABLE,NOT_AVAILABLE,ERROR,NUMBER_OF_ADULTS_NOT_ACCEPTED,NUMBER_OF_CHILDREN_NOT_ACCEPTED,NUMBER_OF_INFANTS_NOT_ACCEPTED,NUMBER_OF_PERSONS_NOT_ACCEPTED,CHECK_IN_AGE_NOT_ACCEPTED

## Entries

| | |
|---|---|
| [AVAILABLE](-a-v-a-i-l-a-b-l-e/index.md) | [JVM]<br>[AVAILABLE](-a-v-a-i-l-a-b-l-e/index.md) |
| [NOT_AVAILABLE](-n-o-t_-a-v-a-i-l-a-b-l-e/index.md) | [JVM]<br>[NOT_AVAILABLE](-n-o-t_-a-v-a-i-l-a-b-l-e/index.md) |
| [ERROR](-e-r-r-o-r/index.md) | [JVM]<br>[ERROR](-e-r-r-o-r/index.md) |
| [NUMBER_OF_ADULTS_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-a-d-u-l-t-s_-n-o-t_-a-c-c-e-p-t-e-d/index.md) | [JVM]<br>[NUMBER_OF_ADULTS_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-a-d-u-l-t-s_-n-o-t_-a-c-c-e-p-t-e-d/index.md) |
| [NUMBER_OF_CHILDREN_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-c-h-i-l-d-r-e-n_-n-o-t_-a-c-c-e-p-t-e-d/index.md) | [JVM]<br>[NUMBER_OF_CHILDREN_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-c-h-i-l-d-r-e-n_-n-o-t_-a-c-c-e-p-t-e-d/index.md) |
| [NUMBER_OF_INFANTS_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-i-n-f-a-n-t-s_-n-o-t_-a-c-c-e-p-t-e-d/index.md) | [JVM]<br>[NUMBER_OF_INFANTS_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-i-n-f-a-n-t-s_-n-o-t_-a-c-c-e-p-t-e-d/index.md) |
| [NUMBER_OF_PERSONS_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-p-e-r-s-o-n-s_-n-o-t_-a-c-c-e-p-t-e-d/index.md) | [JVM]<br>[NUMBER_OF_PERSONS_NOT_ACCEPTED](-n-u-m-b-e-r_-o-f_-p-e-r-s-o-n-s_-n-o-t_-a-c-c-e-p-t-e-d/index.md) |
| [CHECK_IN_AGE_NOT_ACCEPTED](-c-h-e-c-k_-i-n_-a-g-e_-n-o-t_-a-c-c-e-p-t-e-d/index.md) | [JVM]<br>[CHECK_IN_AGE_NOT_ACCEPTED](-c-h-e-c-k_-i-n_-a-g-e_-n-o-t_-a-c-c-e-p-t-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-1869760548%2FProperties%2F699445674) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Hotel.Status](index.md)&gt;[entries](index.md#-1869760548%2FProperties%2F699445674)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#-1583408677%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-1583408677%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Hotel.Status](index.md)&gt;[getEntries](get-entries.md)()<br>Indicates whether there are available offers at the property during the dates requested, as well as information as to why.  Note that pricing will <u>only</u> be present in the API response for a status of `AVAILABLE`.  If there are no rooms available at the property for the dates requested, then `NOT_AVAILABLE` will be returned.  If there are available rooms, but none that meet the specific parameters of the search request, then one of the other messages will be returned. Values: AVAILABLE,NOT_AVAILABLE,ERROR,NUMBER_OF_ADULTS_NOT_ACCEPTED,NUMBER_OF_CHILDREN_NOT_ACCEPTED,NUMBER_OF_INFANTS_NOT_ACCEPTED,NUMBER_OF_PERSONS_NOT_ACCEPTED,CHECK_IN_AGE_NOT_ACCEPTED |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [Hotel.Status](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Hotel.Status](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
