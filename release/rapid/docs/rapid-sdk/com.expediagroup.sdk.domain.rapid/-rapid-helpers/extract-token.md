//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.domain.rapid](../index.md)/[RapidHelpers](index.md)/[extractToken](extract-token.md)

# extractToken

[JVM]\

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Construct operation using Link&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;Operation(link: Link)&quot;))

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~extractToken~~](extract-token.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)url)

---

### Deprecated

Construct operation using Link

#### Replace with

```kotlin
Operation(link: Link)
```
---

Extracts the token parameter from a URL string if it exists; otherwise, returns null.
