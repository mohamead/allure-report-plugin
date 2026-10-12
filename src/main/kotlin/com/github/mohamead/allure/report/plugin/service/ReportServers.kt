package com.github.mohamead.allure.report.plugin.service

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.github.mohamead.allure.report.ReportServer

/**
 * Keeps track of the report web servers started by the Serve and Open actions. Any number can run side by side
 * (e.g. two reports in two browser tabs); they are all stopped, and their temporary reports deleted, when the
 * IDE (or the plugin) shuts down.
 */
@Service(Service.Level.APP)
internal class ReportServers : Disposable {

    private val servers = mutableListOf<ReportServer>()
    private var disposed = false

    /** Starts a server with [start] and tracks it until shutdown. */
    fun start(start: () -> ReportServer): ReportServer {
        val server = start()
        val track = synchronized(servers) { !disposed && servers.add(server) }
        if (!track) server.close()
        return server
    }

    override fun dispose() {
        val running = synchronized(servers) {
            disposed = true
            servers.toList().also { servers.clear() }
        }
        running.forEach { it.close() }
    }
}
