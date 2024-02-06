/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main.kotlin.com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.plugin.logging.ExpediaGroupLoggerFactory
import okhttp3.Call
import okhttp3.Connection
import okhttp3.EventListener
import okhttp3.Handshake
import okhttp3.Protocol
import java.io.IOException
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy

class OkHttpEventListener : EventListener() {
    companion object {
        private val log = ExpediaGroupLoggerFactory.getLogger(this::class.java)
    }

    override fun callStart(call: Call) {
        super.callStart(call)
        log.debug("call start")
    }

    override fun callEnd(call: Call) {
        super.callEnd(call)
        log.debug("call end")
    }

    override fun dnsStart(
        call: Call,
        domainName: String
    ) {
        super.dnsStart(call, domainName)
        log.debug("dns lookup start for domain: %s".format(domainName))
    }

    override fun dnsEnd(
        call: Call,
        domainName: String,
        inetAddressList: List<InetAddress>
    ) {
        super.dnsEnd(call, domainName, inetAddressList)
        log.debug("dns lookup end for domain: %s".format(domainName))
    }

    override fun callFailed(
        call: Call,
        ioe: IOException
    ) {
        super.callFailed(call, ioe)
        log.debug("call failed with exception: %s".format(ioe.message))
    }

    override fun canceled(call: Call) {
        super.canceled(call)
        log.debug("call canceled")
    }

    override fun connectStart(
        call: Call,
        inetSocketAddress: InetSocketAddress,
        proxy: Proxy
    ) {
        super.connectStart(call, inetSocketAddress, proxy)
        log.debug("connect start")
    }

    override fun connectEnd(
        call: Call,
        inetSocketAddress: InetSocketAddress,
        proxy: Proxy,
        protocol: Protocol?
    ) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol)
        log.debug("connect end")
    }

    override fun connectFailed(
        call: Call,
        inetSocketAddress: InetSocketAddress,
        proxy: Proxy,
        protocol: Protocol?,
        ioe: IOException
    ) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe)
        log.debug("connect failed with exception: %s".format(ioe.message))
    }

    override fun connectionAcquired(
        call: Call,
        connection: Connection
    ) {
        super.connectionAcquired(call, connection)
        log.debug("connection acquired")
    }

    override fun connectionReleased(
        call: Call,
        connection: Connection
    ) {
        super.connectionReleased(call, connection)
        log.debug("connection released")
    }

    override fun secureConnectStart(call: Call) {
        super.secureConnectStart(call)
        log.debug("secure connect start")
    }

    override fun secureConnectEnd(
        call: Call,
        handshake: Handshake?
    ) {
        super.secureConnectEnd(call, handshake)
        log.debug("secure connect end")
    }
}
