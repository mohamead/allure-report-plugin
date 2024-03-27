package com.github.mohamead.allure.report.plugin.util

import com.github.mohamead.allure.report.plugin.action.args.Command
import com.github.mohamead.allure.report.plugin.action.args.CommandOption
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

internal fun showIfValidFolderName(e: AnActionEvent, folderNames: HashSet<String>) {
    val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
    val isValid = (virtualFile != null && virtualFile.isDirectory && folderNames.contains(virtualFile.name))
    e.presentation.isEnabledAndVisible = isValid
}

internal fun MutableSet<String>.addCommandOption(option: CommandOption): MutableSet<String> {
    this.addValue(option.value)
    return this
}

internal fun MutableSet<String>.addValue(option: String): MutableSet<String> {
    this.add(option)
    return this
}

internal fun MutableSet<String>.addCommand(command: Command): MutableSet<String> {
    this.addValue(command.value)
    return this
}

internal fun getAllureCommand(): MutableSet<String> {
    val osName = System.getProperty("os.name").lowercase()
    val allureCommand = mutableSetOf<String>()
    if ("windows" in osName) {
        allureCommand.add(Command.ALLURE_WINDOWS.value)
    } else {
        allureCommand.add(Command.ALLURE_OTHER.value)
    }
    return allureCommand
}

internal fun runProcess(command: Array<String>): Process {
    return Runtime.getRuntime().exec(command, null)
}
