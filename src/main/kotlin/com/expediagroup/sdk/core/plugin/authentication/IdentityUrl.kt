package com.expediagroup.sdk.core.plugin.authentication

object IdentityUrl {
    private const val IDENTITY_SUFFIX = "/identity/oauth2/v2/token"

    /**
     * Builds the identity URL for the given [baseUrl], removing any extra slashes.
     *
     * @param baseUrl The base URL of the service.
     * @return The identity URL.
     */
    fun from(baseUrl: String): String {
        return "$baseUrl$IDENTITY_SUFFIX".replace("(?<=[^:\\s])(\\/+\\/)", "/")
    }
}
