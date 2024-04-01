package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.action.args.Command.SERVE
import com.github.mohamead.allure.report.plugin.action.args.CommandOption.HOST
import com.github.mohamead.allure.report.plugin.util.addCommand
import com.github.mohamead.allure.report.plugin.util.addCommandOption
import com.github.mohamead.allure.report.plugin.util.addValue
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.openapi.actionSystem.AnActionEvent

internal class ServeAction : AllureAction() {

    private val serveCommand: MutableSet<String> = mutableSetOf()

    internal companion object {
        val serveFolders: HashSet<String> = hashSetOf("allure-results", "failsafe-reports", "surefire-reports")
    }

    override fun actionPerformed(e: AnActionEvent) {
        val path = getPath(e)

        runCommand(
            serveCommand
                .addCommand(SERVE).addValue(path)
                .addCommandOption(HOST).addValue(localHost)
        )
    }

    override fun update(e: AnActionEvent) {
        showIfValidFolderName(e, serveFolders)
    }

}
