package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.action.OpenAction.Companion.openFolders
import com.github.mohamead.allure.report.plugin.action.ServeAction.Companion.serveFolders
import com.github.mohamead.allure.report.plugin.action.args.Command.GENERATE
import com.github.mohamead.allure.report.plugin.action.args.CommandOption.CLEAN
import com.github.mohamead.allure.report.plugin.action.args.CommandOption.OUTPUT
import com.github.mohamead.allure.report.plugin.util.addCommand
import com.github.mohamead.allure.report.plugin.util.addCommandOption
import com.github.mohamead.allure.report.plugin.util.addValue
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.ide.SaveAndSyncHandler
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.vfs.VirtualFileManager

internal class GenerateAction : AllureAction() {

    internal companion object {
        val generateFolder: HashSet<String> = hashSetOf(serveFolders.first())
    }

    override fun actionPerformed(e: AnActionEvent) {
        val generateCommand: MutableSet<String> = mutableSetOf()
        val origin = getPath(e)
        val destination = origin.replace(generateFolder.first(), openFolders.first())

        save(e)
        runCommand(
            generateCommand
                .addCommand(GENERATE).addValue(origin)
                .addCommandOption(OUTPUT).addValue(destination)
                .addCommandOption(CLEAN)
        )
        refresh()
    }

    override fun update(e: AnActionEvent) {
        showIfValidFolderName(e, generateFolder)
    }

    private fun save(e: AnActionEvent) {
        e.project!!.save()
        FileDocumentManager.getInstance().saveAllDocuments()
    }

    private fun refresh() {
        SaveAndSyncHandler.getInstance().refreshOpenFiles()
        VirtualFileManager.getInstance().refreshWithoutFileWatcher(false)
    }

}
