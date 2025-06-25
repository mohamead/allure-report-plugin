package com.github.mohamead.allure.report.plugin.provider

import com.github.mohamead.allure.report.plugin.action.MainActionGroup.Companion.allFolders
import com.github.mohamead.allure.report.plugin.icon.PluginIcons.allure
import com.github.mohamead.allure.report.plugin.util.matchAny
import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

internal class AllureIconProvider : FileIconProvider {

    override fun getIcon(file: VirtualFile, flags: Int, project: Project?): Icon? {
        if (file.isDirectory && allFolders.matchAny(file.name.lowercase().trim())) {
            return allure
        }
        return null
    }

}