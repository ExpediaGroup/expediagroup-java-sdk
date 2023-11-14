//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[DirectDebitAllOf](index.md)/[getMandateType](get-mandate-type.md)

# getMandateType

[JVM]\

public final [DirectDebitAllOf.MandateType](-mandate-type/index.md)[getMandateType](get-mandate-type.md)()

#### Parameters

JVM

| | |
|---|---|
| mandateType | The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` |
