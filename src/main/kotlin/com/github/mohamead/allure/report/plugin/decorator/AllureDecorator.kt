package com.github.mohamead.allure.report.plugin.decorator

import com.github.mohamead.allure.report.plugin.action.MainActionGroup.Companion.allFolders
import com.github.mohamead.allure.report.plugin.icon.PluginIcons.allure
import com.github.mohamead.allure.report.plugin.util.matchAny
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ProjectViewNode
import com.intellij.ide.projectView.ProjectViewNodeDecorator
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.psi.PsiDirectory

internal class AllureDecorator : ProjectViewNodeDecorator {

    override fun decorate(node: ProjectViewNode<*>, data: PresentationData) {
        when (node) {
            is PsiDirectoryNode -> {
                val directory = node.value
                if (directory != null && !isProjectRoot(directory)) {
                    if (allFolders.matchAny(directory.name.lowercase().trim())) {
                        data.setIcon(allure)
                    }
                }
            }
        }
    }

    private fun isProjectRoot(directory: PsiDirectory): Boolean {
        return directory.virtualFile.path == directory.project.basePath
    }

}