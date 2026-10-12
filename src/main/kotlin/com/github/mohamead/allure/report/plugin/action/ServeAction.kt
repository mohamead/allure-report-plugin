package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.service.ReportServers
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.github.mohamead.allure.report.AllureReport

internal class ServeAction : AllureAction() {

    internal companion object {
        val serveFolders: HashSet<String> = hashSetOf("allure-results", "failsafe-reports", "surefire-reports")
    }

    override fun actionPerformed(e: AnActionEvent) {
        val path = getPath(e)

        runInBackground("serve $path") {
            service<ReportServers>().start { AllureReport().serve(listOf(path), host = localHost) }
        }
    }

    override fun update(e: AnActionEvent) {
        showIfValidFolderName(e, serveFolders)
    }

}
