package com.github.mohamead.allure.report.plugin.util

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

internal fun showIfValidFolderName(e: AnActionEvent, folderNames: HashSet<String>) {
    val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
    val isValid = (virtualFile != null && virtualFile.isDirectory && folderNames.matchAny(virtualFile.name))
    e.presentation.isEnabledAndVisible = isValid
}

internal fun MutableSet<String>.matchAny(value: String): Boolean {
    return this.any { value.contains(it) }
}
