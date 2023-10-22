//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[SaleScenario](index.md)/[getMember](get-member.md)

# getMember

[JVM]\

public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMember](get-member.md)()

#### Parameters

JVM

| | |
|---|---|
| member | If true, this rate has a \&quot;Member Only Deal\&quot; discount applied to the rate.  Partners must be enabled to receive \&quot;Member Only Deals\&quot;. If interested, partners should speak to their account representatives.  This parameter can be used to merchandise if a \&quot;Member Only Deal\&quot; has been applied, which will help drive loyalty. In addition, it can be used by OTA's to create an opaque, but public shopping experience.  This value will always be false for requests where the sales_environment is equal to \&quot;hotel_package\&quot;. |
