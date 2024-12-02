package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.util.runProcess
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.DumbAware

internal abstract class AllureAction : AnAction(), DumbAware {

    private val LOGGER: Logger = Logger.getInstance(AllureAction::class.java)
    protected val localHost = "localhost"

    protected open fun runCommand(command: MutableSet<String>) {
        LOGGER.info("Command : java -jar allure-commandline-2.33-SNAPSHOT.jar ${command.joinToString(separator = " ")}")
        runProcess(command)
    }

    protected fun getPath(e: AnActionEvent): String {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)!!
        return virtualFile.toNioPath().toAbsolutePath().toString()
    }

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

}
