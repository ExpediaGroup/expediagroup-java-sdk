package com.expediagroup.sdk.core.constant

object Logging {
    const val RENEWING_TOKEN = "Renewing token"
    const val SUCCESSFUL_TOKEN_RENEWAL = "Token renewal successful: New token expires in {} seconds"
    const val FAILED_TOKEN_RENEWAL = "Token renewal failed: Response status[{}]"
    const val CLEARING_TOKENS = "Clearing tokens"
    const val TOKEN_EXPIRED = "Token expired or is about to expire: Requests will wait until token is renewed"
}