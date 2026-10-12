package com.github.mohamead.allure.report.plugin

import io.qameta.allure.Owner
import com.github.mohamead.allure.report.AllureReport
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists

internal class AllureReportApiTest {

    @TempDir
    lateinit var tmp: Path

    private val results = Paths.get("src", "test", "testData", "allure-results").toAbsolutePath()

    @Owner("Mohamed Adrik")
    @Test
    fun generateReportTest() {
        val report = AllureReport.generate {
            results(results)
            output(tmp.resolve("allure-report"))
            clean = true
        }
        assertTrue(report.indexHtml.exists())
    }

    @Owner("Mohamed Adrik")
    @Test
    fun serveResultsTest() {
        AllureReport().serve(listOf(results), openBrowser = false).use {
            assertTrue(it.url.port > 0)
        }
    }

}
