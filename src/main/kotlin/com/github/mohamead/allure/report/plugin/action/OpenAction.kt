package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.service.ReportServers
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.github.mohamead.allure.report.AllureReport

internal class OpenAction : AllureAction() {

    internal companion object {
        val openFolders: HashSet<String> = hashSetOf("allure-report")
    }

    override fun actionPerformed(e: AnActionEvent) {
        val path = getPath(e)

        runInBackground("open $path") {
            service<ReportServers>().start { AllureReport.open(path, host = localHost) }
        }
    }

    override fun update(e: AnActionEvent) {
        showIfValidFolderName(e, openFolders)
    }

}
