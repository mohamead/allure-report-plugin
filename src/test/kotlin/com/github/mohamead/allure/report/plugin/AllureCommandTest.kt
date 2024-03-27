package com.github.mohamead.allure.report.plugin

import com.github.mohamead.allure.report.plugin.util.addValue
import com.github.mohamead.allure.report.plugin.util.getAllureCommand
import com.github.mohamead.allure.report.plugin.util.runProcess
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AllureCommandTest {

    private val allureCommand = getAllureCommand()

    @Test
    fun helpCommandTest() {
        val helpCommand = allureCommand.addValue("--help")
        val result = runCommand(helpCommand)
        assertEquals(0, result)
    }

    @Test
    fun versionCommandTest() {
        val versionCommand = allureCommand.addValue("--version")
        val result = runCommand(versionCommand)
        assertEquals(0, result)
    }

    private fun runCommand(command: MutableSet<String>): Int {
        println("Command : ${command.joinToString(separator = " ")}")
        return runProcess(command.toTypedArray()).waitFor()
    }

}
