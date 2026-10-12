package com.github.mohamead.allure.report.plugin.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.DumbAware
import java.nio.file.Path

internal abstract class AllureAction : AnAction(), DumbAware {

    protected val logger: Logger = Logger.getInstance(javaClass)
    protected val localHost = "localhost"

    /** Runs [task] off the EDT; failures are logged instead of being lost on the pooled thread. */
    protected fun runInBackground(description: String, task: () -> Unit) {
        logger.info("Allure: $description")
        ApplicationManager.getApplication().executeOnPooledThread {
            try {
                task()
            } catch (e: Exception) {
                logger.warn("Allure: $description failed", e)
            }
        }
    }

    protected fun getPath(e: AnActionEvent): Path {
        val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)!!
        return virtualFile.toNioPath().toAbsolutePath()
    }

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

}
