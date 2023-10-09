//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverDeviceDetails](index.md)/[AccountTakeoverDeviceDetails](-account-takeover-device-details.md)

# AccountTakeoverDeviceDetails

[JVM]\

public [AccountTakeoverDeviceDetails](index.md)[AccountTakeoverDeviceDetails](-account-takeover-device-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)deviceBox, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ipAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)userAgent, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)source, [AccountTakeoverDeviceDetails.Type](-type/index.md)type)

#### Parameters

JVM

| | |
|---|---|
| deviceBox | Device related information retrieved from TrustWidget. |
| ipAddress | IP address of the device used for this event. |
| userAgent | The application type, operating system, software vendor, or software version of the originating request. |
| source | Source of the device_box. Default value is `TrustWidget`. |
| type | The categorized type of device used by a user. Possible values are: - `WEBSITE` - Applicable if the user initiated this event from a web browser on a desktop computer. - `PHONE_WEB` - Applicable if the user initiated this event from a web browser on a phone. - `TABLET_WEB` - Applicable if the user initiated this event from a web browser on a tablet. - `PHONE_APP` - Applicable if the user initiated this event from an app on a phone. - `TABLET_APP` - Applicable if the user initiated this event from an app on a tablet. |
