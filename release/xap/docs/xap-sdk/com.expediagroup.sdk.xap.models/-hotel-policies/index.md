//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelPolicies](index.md)

# HotelPolicies

public final class [HotelPolicies](index.md)

Container for Hotel policy information.

#### Parameters

JVM

| | |
|---|---|
| checkInStartTime | Beginning of the standard check-in window on the check in date, and in the local time of the hotel. |
| checkInEndTime | End of the standard check-in window on the check in date, and in the local time of the hotel. |
| specialCheckInInstructions | Some special instructions needed care by customer when check in. |
| checkOutTime | Customers must check out before this time on the check out date, expressed in the local time of the hotel. |
| petPolicies | The policy of the property toward having pets stay with guests. |
| childrenAndExtraBedsPolicies | The policy of the hotel for having children stay at the hotel, as well as for including extra beds in the room. |

## Constructors

| | |
|---|---|
| [HotelPolicies](-hotel-policies.md) | [JVM]<br>public [HotelPolicies](index.md)[HotelPolicies](-hotel-policies.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkInStartTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkInEndTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;specialCheckInInstructions, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkOutTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;petPolicies, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;childrenAndExtraBedsPolicies) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [checkInEndTime](index.md#743788931%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkInEndTime](index.md#743788931%2FProperties%2F699445674) |
| [checkInStartTime](index.md#-1924731940%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkInStartTime](index.md#-1924731940%2FProperties%2F699445674) |
| [checkOutTime](index.md#1658037483%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkOutTime](index.md#1658037483%2FProperties%2F699445674) |
| [childrenAndExtraBedsPolicies](index.md#884560548%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[childrenAndExtraBedsPolicies](index.md#884560548%2FProperties%2F699445674) |
| [petPolicies](index.md#-888583155%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[petPolicies](index.md#-888583155%2FProperties%2F699445674) |
| [specialCheckInInstructions](index.md#-1912773147%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[specialCheckInInstructions](index.md#-1912773147%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelPolicies.Builder](-builder/index.md)[builder](builder.md)() |
| [getCheckInEndTime](get-check-in-end-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckInEndTime](get-check-in-end-time.md)() |
| [getCheckInStartTime](get-check-in-start-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckInStartTime](get-check-in-start-time.md)() |
| [getCheckOutTime](get-check-out-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckOutTime](get-check-out-time.md)() |
| [getChildrenAndExtraBedsPolicies](get-children-and-extra-beds-policies.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getChildrenAndExtraBedsPolicies](get-children-and-extra-beds-policies.md)() |
| [getPetPolicies](get-pet-policies.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPetPolicies](get-pet-policies.md)() |
| [getSpecialCheckInInstructions](get-special-check-in-instructions.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getSpecialCheckInInstructions](get-special-check-in-instructions.md)() |
