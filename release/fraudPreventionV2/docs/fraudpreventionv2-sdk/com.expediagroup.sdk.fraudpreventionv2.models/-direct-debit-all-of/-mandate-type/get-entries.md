//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[DirectDebitAllOf](../index.md)/[MandateType](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[DirectDebitAllOf.MandateType](index.md)&gt;[getEntries](get-entries.md)()

The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` Values: ONE_OFF,RECURRING
