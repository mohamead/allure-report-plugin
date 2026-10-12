package com.github.mohamead.allure.report.plugin

import com.github.mohamead.allure.report.plugin.service.ReportServers
import io.qameta.allure.Owner
import com.github.mohamead.allure.report.AllureReport
import com.github.mohamead.allure.report.ReportServer
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.net.InetSocketAddress
import java.net.Socket
import java.nio.file.Path

internal class ReportServersTest {

    @TempDir
    lateinit var tmp: Path

    private val servers = ReportServers()

    private fun start(): ReportServer = AllureReport.open(tmp, openBrowser = false)

    private fun isListening(server: ReportServer): Boolean =
        try {
            Socket().use { it.connect(InetSocketAddress(server.url.host, server.url.port), 1000) }
            true
        } catch (_: java.io.IOException) {
            false
        }

    @Owner("Mohamed Adrik")
    @Test
    fun serversRunSideBySide() {
        val first = servers.start { start() }
        val second = servers.start { start() }

        assertTrue(isListening(first))
        assertTrue(isListening(second))
        servers.dispose()
    }

    @Owner("Mohamed Adrik")
    @Test
    fun disposeStopsAllServers() {
        val a = servers.start { start() }
        val b = servers.start { start() }

        servers.dispose()

        assertFalse(isListening(a))
        assertFalse(isListening(b))
    }

    @Owner("Mohamed Adrik")
    @Test
    fun serverStartedAfterDisposeIsStopped() {
        servers.dispose()

        val late = servers.start { start() }

        assertFalse(isListening(late))
    }

}
