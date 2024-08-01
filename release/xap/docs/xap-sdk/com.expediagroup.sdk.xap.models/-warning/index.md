//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[Warning](index.md)

# Warning

public final class [Warning](index.md)

There were some errors or events during the transaction, but the API has still returned a response.  Container for all warnings.

#### Parameters

JVM

| | |
|---|---|
| code | The code of a warning. |
| description | A detail information of what happened. |
| originalPrice |
| newPrice |
| changedAmount |
| changedPercentage | The changed percentage. In the sample 2.97 means the changed percentage is 2.97%. |

## Constructors

| | |
|---|---|
| [Warning](-warning.md) | [JVM]<br>public [Warning](index.md)[Warning](-warning.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [Money](../-money/index.md)originalPrice, [Money](../-money/index.md)newPrice, [Money](../-money/index.md)changedAmount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changedPercentage) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [changedAmount](index.md#188650968%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Money](../-money/index.md)[changedAmount](index.md#188650968%2FProperties%2F699445674) |
| [changedPercentage](index.md#1095872598%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[changedPercentage](index.md#1095872598%2FProperties%2F699445674) |
| [code](index.md#-2110468663%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[code](index.md#-2110468663%2FProperties%2F699445674) |
| [description](index.md#263408072%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#263408072%2FProperties%2F699445674) |
| [newPrice](index.md#35607341%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Money](../-money/index.md)[newPrice](index.md#35607341%2FProperties%2F699445674) |
| [originalPrice](index.md#-1888286324%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Money](../-money/index.md)[originalPrice](index.md#-1888286324%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Warning.Builder](-builder/index.md)[builder](builder.md)() |
| [getChangedAmount](get-changed-amount.md) | [JVM]<br>public final [Money](../-money/index.md)[getChangedAmount](get-changed-amount.md)() |
| [getChangedPercentage](get-changed-percentage.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getChangedPercentage](get-changed-percentage.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCode](get-code.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getNewPrice](get-new-price.md) | [JVM]<br>public final [Money](../-money/index.md)[getNewPrice](get-new-price.md)() |
| [getOriginalPrice](get-original-price.md) | [JVM]<br>public final [Money](../-money/index.md)[getOriginalPrice](get-original-price.md)() |
