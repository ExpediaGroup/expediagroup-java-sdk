package com.expediagroup.sdk.core.poc.logging

import com.expediagroup.sdk.core.constant.LoggingMessage.LOGGING_PREFIX

fun decorate(msg: String): String = "$LOGGING_PREFIX $msg"
