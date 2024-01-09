//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[NightChargeType](index.md)

# NightChargeType

[JVM]\
public enum [NightChargeType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[NightChargeType](index.md)&gt;

The price breakout type.   * `base_rate` - The room rate without any taxes and fees applied.   * `tax_and_service_fee` - Tax recovery charges, service fees, and taxes. Ensure that you capture these values and display as:                             \&quot;Taxes and Fees\&quot;   * `extra_person_fee` - A per night fee that is charged by a hotel for additional adults over the nightly rate. This fee is included as part of the total.   * `property_fee` - The property fee surcharge type must be displayed beginning on the initial hotel room selection page, immediately after your hotel search results page. This placement is required by the U.S. Federal Trade Commission (FTC).                      Display this surcharge as \&quot;Property Fee\&quot; on your room selection page, as described above, and in all subsequent price breakdowns for the following Points of Sale:                      * `US`                      * `Canada`                      * `Brazil`                      * `LATAM`   * `sales_tax` - Taxes that must be displayed by certain jurisdictional laws. Ensure that you capture these values and display as \&quot;Taxes\&quot;.   * `adjustment` - This is the amount that the individual night have been adjusted/discounted.   * `recovery_charges_and_fees` - Tax recovery charges, service fees, and taxes. Ensure that you capture these values and display as:                                   \&quot;Taxes and Fees\&quot;   * `traveler_service_fee` - Fee charged by Vrbo to support use of online tools, services and functions on its platform which enable guest self service. May be displayed as 'Traveler Service Fee' or 'Service Fee' any time fees are broken out for display on partner sites. Values: BASE_RATE,TAX_AND_SERVICE_FEE,EXTRA_PERSON_FEE,PROPERTY_FEE,SALES_TAX,ADJUSTMENT,RECOVERY_CHARGES_AND_FEES,TRAVELER_SERVICE_FEE

## Entries

| | |
|---|---|
| [BASE_RATE](-b-a-s-e_-r-a-t-e/index.md) | [JVM]<br>[BASE_RATE](-b-a-s-e_-r-a-t-e/index.md) |
| [TAX_AND_SERVICE_FEE](-t-a-x_-a-n-d_-s-e-r-v-i-c-e_-f-e-e/index.md) | [JVM]<br>[TAX_AND_SERVICE_FEE](-t-a-x_-a-n-d_-s-e-r-v-i-c-e_-f-e-e/index.md) |
| [EXTRA_PERSON_FEE](-e-x-t-r-a_-p-e-r-s-o-n_-f-e-e/index.md) | [JVM]<br>[EXTRA_PERSON_FEE](-e-x-t-r-a_-p-e-r-s-o-n_-f-e-e/index.md) |
| [PROPERTY_FEE](-p-r-o-p-e-r-t-y_-f-e-e/index.md) | [JVM]<br>[PROPERTY_FEE](-p-r-o-p-e-r-t-y_-f-e-e/index.md) |
| [SALES_TAX](-s-a-l-e-s_-t-a-x/index.md) | [JVM]<br>[SALES_TAX](-s-a-l-e-s_-t-a-x/index.md) |
| [ADJUSTMENT](-a-d-j-u-s-t-m-e-n-t/index.md) | [JVM]<br>[ADJUSTMENT](-a-d-j-u-s-t-m-e-n-t/index.md) |
| [RECOVERY_CHARGES_AND_FEES](-r-e-c-o-v-e-r-y_-c-h-a-r-g-e-s_-a-n-d_-f-e-e-s/index.md) | [JVM]<br>[RECOVERY_CHARGES_AND_FEES](-r-e-c-o-v-e-r-y_-c-h-a-r-g-e-s_-a-n-d_-f-e-e-s/index.md) |
| [TRAVELER_SERVICE_FEE](-t-r-a-v-e-l-e-r_-s-e-r-v-i-c-e_-f-e-e/index.md) | [JVM]<br>[TRAVELER_SERVICE_FEE](-t-r-a-v-e-l-e-r_-s-e-r-v-i-c-e_-f-e-e/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-565674081%2FProperties%2F700308213) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[NightChargeType](index.md)&gt;[entries](index.md#-565674081%2FProperties%2F700308213)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#2145318494%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#2145318494%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[NightChargeType](index.md)&gt;[getEntries](get-entries.md)()<br>The price breakout type.   * `base_rate` - The room rate without any taxes and fees applied.   * `tax_and_service_fee` - Tax recovery charges, service fees, and taxes. Ensure that you capture these values and display as:                             \&quot;Taxes and Fees\&quot;   * `extra_person_fee` - A per night fee that is charged by a hotel for additional adults over the nightly rate. This fee is included as part of the total.   * `property_fee` - The property fee surcharge type must be displayed beginning on the initial hotel room selection page, immediately after your hotel search results page. This placement is required by the U.S. Federal Trade Commission (FTC).                      Display this surcharge as \&quot;Property Fee\&quot; on your room selection page, as described above, and in all subsequent price breakdowns for the following Points of Sale:                      * `US`                      * `Canada`                      * `Brazil`                      * `LATAM`   * `sales_tax` - Taxes that must be displayed by certain jurisdictional laws. Ensure that you capture these values and display as \&quot;Taxes\&quot;.   * `adjustment` - This is the amount that the individual night have been adjusted/discounted.   * `recovery_charges_and_fees` - Tax recovery charges, service fees, and taxes. Ensure that you capture these values and display as:                                   \&quot;Taxes and Fees\&quot;   * `traveler_service_fee` - Fee charged by Vrbo to support use of online tools, services and functions on its platform which enable guest self service. May be displayed as 'Traveler Service Fee' or 'Service Fee' any time fees are broken out for display on partner sites. Values: BASE_RATE,TAX_AND_SERVICE_FEE,EXTRA_PERSON_FEE,PROPERTY_FEE,SALES_TAX,ADJUSTMENT,RECOVERY_CHARGES_AND_FEES,TRAVELER_SERVICE_FEE |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [NightChargeType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[NightChargeType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
