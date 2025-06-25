package com.github.mohamead.allure.report.plugin.decorator

import com.github.mohamead.allure.report.plugin.action.MainActionGroup.Companion.allFolders
import com.github.mohamead.allure.report.plugin.icon.PluginIcons.allure
import com.github.mohamead.allure.report.plugin.util.matchAny
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ProjectViewNode
import com.intellij.ide.projectView.ProjectViewNodeDecorator
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode

internal class AllureDecorator : ProjectViewNodeDecorator {

    override fun decorate(node: ProjectViewNode<*>?, data: PresentationData?) {
        when (node) {
            is PsiDirectoryNode -> {
                if (data != null && node.value != null) {
                    if (allFolders.matchAny(node.value.name.lowercase().trim())) {
                        data.setIcon(allure)
                    }
                }
            }
        }
    }

}