package com.github.mohamead.allure.report.plugin

import com.github.mohamead.allure.report.plugin.action.args.Command
import com.github.mohamead.allure.report.plugin.action.args.CommandOption
import com.github.mohamead.allure.report.plugin.util.addCommand
import com.github.mohamead.allure.report.plugin.util.addCommandOption
import com.github.mohamead.allure.report.plugin.util.addValue
import io.qameta.allure.CommandLine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.nio.file.Paths

internal class AllureCommandTest {

    private val allureCommand = mutableSetOf<String>()

    @Disabled
    @Test
    fun helpCommandTest() {
        val helpCommand = allureCommand.addValue("--help")
        val result = runCommand(helpCommand)
        assertEquals(0, result)
    }

    @Disabled
    @Test
    fun versionCommandTest() {
        val versionCommand = allureCommand.addValue("--version")
        val result = runCommand(versionCommand)
        assertEquals(0, result)
    }

    @Disabled
    @Test
    fun generateCommandTest() {
        val resultPath = Paths.get("src", "test", "testData", "allure-results").toAbsolutePath().toString()
        val reportPath = Paths.get("src", "test", "testData", "allure-report").toAbsolutePath().toString()
        val generateCommand = allureCommand
            .addCommand(Command.GENERATE).addValue(resultPath)
            .addCommandOption(CommandOption.OUTPUT).addValue(reportPath)
            .addCommandOption(CommandOption.CLEAN)
        runCommand(generateCommand)
    }

    private fun runCommand(command: MutableSet<String>): Int {
        println("Command : ${command.joinToString(separator = " ")}")
        CommandLine.main(command.toTypedArray())
        return 0
    }

}
