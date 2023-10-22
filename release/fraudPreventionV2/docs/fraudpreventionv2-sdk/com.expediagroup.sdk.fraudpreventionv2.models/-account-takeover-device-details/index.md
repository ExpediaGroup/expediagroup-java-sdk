//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverDeviceDetails](index.md)

# AccountTakeoverDeviceDetails

public final class [AccountTakeoverDeviceDetails](index.md)

Information specific to the Partner's device through which a transaction was made.

#### Parameters

JVM

| | |
|---|---|
| deviceBox | Device related information retrieved from TrustWidget. |
| ipAddress | IP address of the device used for this event. |
| userAgent | The application type, operating system, software vendor, or software version of the originating request. |
| source | Source of the device_box. Default value is `TrustWidget`. |
| type | The categorized type of device used by a user. Possible values are: - `WEBSITE` - Applicable if the user initiated this event from a web browser on a desktop computer. - `PHONE_WEB` - Applicable if the user initiated this event from a web browser on a phone. - `TABLET_WEB` - Applicable if the user initiated this event from a web browser on a tablet. - `PHONE_APP` - Applicable if the user initiated this event from an app on a phone. - `TABLET_APP` - Applicable if the user initiated this event from an app on a tablet. |

## Constructors

| | |
|---|---|
| [AccountTakeoverDeviceDetails](-account-takeover-device-details.md) | [JVM]<br>public [AccountTakeoverDeviceDetails](index.md)[AccountTakeoverDeviceDetails](-account-takeover-device-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)deviceBox, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ipAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)userAgent, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)source, [AccountTakeoverDeviceDetails.Type](-type/index.md)type) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverDeviceDetails.Type](-type/index.md)&gt;<br>The categorized type of device used by a user. Possible values are: - `WEBSITE` - Applicable if the user initiated this event from a web browser on a desktop computer. - `PHONE_WEB` - Applicable if the user initiated this event from a web browser on a phone. - `TABLET_WEB` - Applicable if the user initiated this event from a web browser on a tablet. - `PHONE_APP` - Applicable if the user initiated this event from an app on a phone. - `TABLET_APP` - Applicable if the user initiated this event from an app on a tablet. Values: WEBSITE,PHONE_WEB,TABLET_WEB,PHONE_APP,TABLET_APP |

## Properties

| Name | Summary |
|---|---|
| [deviceBox](index.md#1175843190%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 16000)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[deviceBox](index.md#1175843190%2FProperties%2F-173342751) |
| [ipAddress](index.md#667263806%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ipAddress](index.md#667263806%2FProperties%2F-173342751) |
| [source](index.md#-1057946860%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[source](index.md#-1057946860%2FProperties%2F-173342751) |
| [type](index.md#1697605973%2FProperties%2F-173342751) | [JVM]<br>private final [AccountTakeoverDeviceDetails.Type](-type/index.md)[type](index.md#1697605973%2FProperties%2F-173342751) |
| [userAgent](index.md#-813191503%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[userAgent](index.md#-813191503%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountTakeoverDeviceDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getDeviceBox](get-device-box.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDeviceBox](get-device-box.md)() |
| [getIpAddress](get-ip-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getIpAddress](get-ip-address.md)() |
| [getSource](get-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSource](get-source.md)() |
| [getType](get-type.md) | [JVM]<br>public final [AccountTakeoverDeviceDetails.Type](-type/index.md)[getType](get-type.md)() |
| [getUserAgent](get-user-agent.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUserAgent](get-user-agent.md)() |
