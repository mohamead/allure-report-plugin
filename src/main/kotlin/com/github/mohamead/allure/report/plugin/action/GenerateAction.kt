package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.action.OpenAction.Companion.openFolders
import com.github.mohamead.allure.report.plugin.action.ServeAction.Companion.serveFolders
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.ide.SaveAndSyncHandler
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.vfs.VirtualFileManager
import com.github.mohamead.allure.report.AllureReport
import com.github.mohamead.allure.report.ReportOptions
import java.nio.file.Path

internal class GenerateAction : AllureAction() {

    internal companion object {
        val generateFolder: HashSet<String> = hashSetOf(serveFolders.first())
    }

    override fun actionPerformed(e: AnActionEvent) {
        val origin = getPath(e)
        val destination = Path.of(origin.toString().replace(generateFolder.first(), openFolders.first()))

        save(e)
        runInBackground("generate $origin -> $destination") {
            AllureReport(ReportOptions(cleanOutputDirectory = true)).generate(origin, destination)
            refresh()
        }
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
