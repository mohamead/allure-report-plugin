package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.action.args.Command.SERVE
import com.github.mohamead.allure.report.plugin.action.args.CommandOption.HOST
import com.github.mohamead.allure.report.plugin.util.addCommand
import com.github.mohamead.allure.report.plugin.util.addCommandOption
import com.github.mohamead.allure.report.plugin.util.addValue
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

internal class ServeAction : AllureAction() {

    internal companion object {
        val serveFolders: HashSet<String> = hashSetOf("allure-results", "failsafe-reports", "surefire-reports")
    }

    override fun actionPerformed(e: AnActionEvent) {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)!!
        val path = virtualFile.path

        runCommand(
            allureCommand
                .addCommand(SERVE).addValue(path)
                .addCommandOption(HOST).addValue(localHost)
        )
    }

    override fun update(e: AnActionEvent) {
        showIfValidFolderName(e, serveFolders)
    }

}
