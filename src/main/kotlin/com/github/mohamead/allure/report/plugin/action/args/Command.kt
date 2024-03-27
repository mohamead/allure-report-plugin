package com.github.mohamead.allure.report.plugin.action.args

internal enum class Command(val value: String) {
    ALLURE_WINDOWS("allure.bat"),
    ALLURE_OTHER("allure"),
    OPEN("open"),
    SERVE("serve")
}
