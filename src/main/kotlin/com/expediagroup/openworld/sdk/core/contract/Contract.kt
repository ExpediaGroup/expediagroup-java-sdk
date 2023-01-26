package com.expediagroup.openworld.sdk.core.contract

internal typealias Operation = (String) -> String

/**
 * A contract for a specific [operation].
 *
 * @property operation The operation to perform on a string.
 */
internal enum class Contract(val operation: Operation) {
    TRAILING_SLASH({ if (it.endsWith("/")) it else "$it/" })
}

/**
 * Adheres to the given [contract] on a [String].
 *
 * @param contract the [Contract] to adhere to.
 * @return the [String] adhering to the given [contract].
 */
internal fun String.adhereTo(contract: Contract): String = contract.operation(this)
