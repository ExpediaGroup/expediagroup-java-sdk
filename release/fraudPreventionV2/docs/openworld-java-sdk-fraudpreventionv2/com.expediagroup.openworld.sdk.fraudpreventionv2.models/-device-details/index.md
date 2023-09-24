//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[DeviceDetails](index.md)

# DeviceDetails

public final class [DeviceDetails](index.md)

#### Parameters

JVM

| | |
|---|---|
| ipAddress | IP address of the device used for booking. |
| source | Source of the device_box. Default value is `TrustWidget`. |
| deviceBox | Device related information retrieved from TrustWidget. |

## Constructors

| | |
|---|---|
| [DeviceDetails](-device-details.md) | [JVM]<br>public [DeviceDetails](index.md)[DeviceDetails](-device-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ipAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)source, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)deviceBox) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [DeviceDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getDeviceBox](get-device-box.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDeviceBox](get-device-box.md)() |
| [getIpAddress](get-ip-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getIpAddress](get-ip-address.md)() |
| [getSource](get-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSource](get-source.md)() |

## Properties

| Name | Summary |
|---|---|
| [deviceBox](index.md#-120099038%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 16000)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[deviceBox](index.md#-120099038%2FProperties%2F-1883119931) |
| [ipAddress](index.md#-628678422%2FProperties%2F-1883119931) | [JVM]<br>@Pattern(regexp = &quot;^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ipAddress](index.md#-628678422%2FProperties%2F-1883119931) |
| [source](index.md#1681671400%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[source](index.md#1681671400%2FProperties%2F-1883119931) |
