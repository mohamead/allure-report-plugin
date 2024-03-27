package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.util.getAllureCommand
import com.github.mohamead.allure.report.plugin.util.runProcess
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.DumbAware

internal abstract class AllureAction : AnAction(), DumbAware {

    private val LOGGER: Logger = Logger.getInstance(AllureAction::class.java)
    protected val allureCommand: MutableSet<String> = getAllureCommand()
    protected val localHost = "localhost"

    protected fun runCommand(command: MutableSet<String>) {
        LOGGER.info("Allure command : ${command.joinToString(separator = " ")}")
        runProcess(command.toTypedArray())
    }

}
