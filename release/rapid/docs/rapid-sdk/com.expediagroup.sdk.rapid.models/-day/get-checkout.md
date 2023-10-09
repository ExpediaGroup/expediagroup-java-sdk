//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Day](index.md)/[getCheckout](get-checkout.md)

# getCheckout

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckout](get-checkout.md)()

#### Parameters

JVM

| | |
|---|---|
| checkout | Enumeration indicating the capability of check-out on the date.  `CHECKOUT_VALID`: The associated date is valid for check out.  `CHECKOUT_INVALID`: The checkout validity value is invalid or unknown.  `CHECKOUT_INVALID_DUE_TO_NON_CHANGEOVER_DAY_OF_WEEK`: The associated date is not valid for check out because it falls on a day of the week that check out is prohibited.  `CHECKOUT_INVALID_DUE_TO_CHANGEOVER_EXCLUSION`: The associated date is not valid for check out because check out was prohibited on that specific date. |
