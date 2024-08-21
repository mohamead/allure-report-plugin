package com.github.mohamead.allure.report.plugin.action

import com.github.mohamead.allure.report.plugin.action.OpenAction.Companion.openFolders
import com.github.mohamead.allure.report.plugin.action.ServeAction.Companion.serveFolders
import com.github.mohamead.allure.report.plugin.util.showIfValidFolderName
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup

internal class MainActionGroup : DefaultActionGroup() {

    private val allFolders = openFolders.union(serveFolders).toHashSet()

    override fun update(e: AnActionEvent) {
        showIfValidFolderName(e, allFolders)
    }

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT
    
}
