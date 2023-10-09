//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[TraderDetailsInner](index.md)

# TraderDetailsInner

public final class [TraderDetailsInner](index.md)

Information of the professional entity that sells the property inventory or related services.

#### Parameters

JVM

| | |
|---|---|
| contactMessage | The trader contact message. |
| name | The trader name. |
| address |
| businessRegisterName | Name of the register where the trader is registered, and is related to the `business_register_number`<br><i><b>NOTE:</b> See our [Digital Services Act](https://developers.expediagroup.com/docs/rapid/resources/reference/digital-services-act) information on Developer Hub.</i> |
| businessRegisterNumber | Business registration number<br><i><b>NOTE:</b> See our [Digital Services Act](https://developers.expediagroup.com/docs/rapid/resources/reference/digital-services-act) information on Developer Hub.</i> |
| selfCertification | Certification that the trader has confirmed their commitment to only offer products or services that comply with the applicable rules of Union law.<br><i><b>NOTE:</b> See our [Digital Services Act](https://developers.expediagroup.com/docs/rapid/resources/reference/digital-services-act) information on Developer Hub.</i> |
| rightToWithdrawMessage | The trader right to withdraw message. |
| email | The trader email address. |
| phone | The trader phone number. |

## Constructors

| | |
|---|---|
| [TraderDetailsInner](-trader-details-inner.md) | [JVM]<br>public [TraderDetailsInner](index.md)[TraderDetailsInner](-trader-details-inner.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)contactMessage, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [TraderAddress](../-trader-address/index.md)address, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)businessRegisterName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)businessRegisterNumber, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)selfCertification, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rightToWithdrawMessage, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)phone) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#461247085%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [TraderAddress](../-trader-address/index.md)[address](index.md#461247085%2FProperties%2F700308213) |
| [businessRegisterName](index.md#-1744673237%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[businessRegisterName](index.md#-1744673237%2FProperties%2F700308213) |
| [businessRegisterNumber](index.md#1663595757%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[businessRegisterNumber](index.md#1663595757%2FProperties%2F700308213) |
| [contactMessage](index.md#1744466226%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[contactMessage](index.md#1744466226%2FProperties%2F700308213) |
| [email](index.md#493521093%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[email](index.md#493521093%2FProperties%2F700308213) |
| [name](index.md#593079790%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#593079790%2FProperties%2F700308213) |
| [phone](index.md#-1822890189%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[phone](index.md#-1822890189%2FProperties%2F700308213) |
| [rightToWithdrawMessage](index.md#995257075%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[rightToWithdrawMessage](index.md#995257075%2FProperties%2F700308213) |
| [selfCertification](index.md#1999317459%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[selfCertification](index.md#1999317459%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [TraderDetailsInner.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [TraderAddress](../-trader-address/index.md)[getAddress](get-address.md)() |
| [getBusinessRegisterName](get-business-register-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBusinessRegisterName](get-business-register-name.md)() |
| [getBusinessRegisterNumber](get-business-register-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBusinessRegisterNumber](get-business-register-number.md)() |
| [getContactMessage](get-contact-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getContactMessage](get-contact-message.md)() |
| [getEmail](get-email.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmail](get-email.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getPhone](get-phone.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPhone](get-phone.md)() |
| [getRightToWithdrawMessage](get-right-to-withdraw-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRightToWithdrawMessage](get-right-to-withdraw-message.md)() |
| [getSelfCertification](get-self-certification.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getSelfCertification](get-self-certification.md)() |
