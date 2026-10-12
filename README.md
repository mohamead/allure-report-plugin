# ![allure-report-plugin](./src/main/resources/META-INF/pluginIcon.svg) Allure Report

![Build](https://github.com/mohamead/allure-report-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/24074)](https://plugins.jetbrains.com/plugin/24074-allure-report/versions)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/24074)](https://plugins.jetbrains.com/plugin/24074-allure-report)
[![BuyMeACoffee](https://raw.githubusercontent.com/pachadotdev/buymeacoffee-badges/main/bmc-donate-yellow.svg)](https://buymeacoffee.com/allurereportplugin)

<!-- Plugin description -->
Simple plugin that wraps the allure commands: **generate**, **open** and **serve**
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Allure Report"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/mohamead/allure-report-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Usage

The plugin is developed without the need of allure being installed. It uses the [allure-report-api][wrapper] library
(a Kotlin wrapper of Allure 2), so reports are generated and served inside the IDE. Once the plugin is installed it will
allow us to perform allure's **generate**, **open** and **serve** command on specific folders.

**Generate**: A pre-request in order to use this command is that the folder-name must contain the value `allure-results`. 

![Image Alt text](/images/Generate.png)

![Image Alt text](/images/Allure.png)

**Open**: A pre-request is that the folder-name must contain the value `allure-report`.

**Serve**: A pre-request is that the folder-name must contain one of the following names `allure-results`, `surefire-reports` or `failsafe-reports`

Serve and Open start a local web server and open the report in your browser. You can have several reports open at the
same time; they are all stopped (and the temporary reports of Serve deleted) when the IDE is closed.

Reports are generated without analytics: nothing is sent to Google Analytics, and the report does not load Google Tag Manager.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

The plugin depends on [allure-report-api][wrapper], which is resolved from [JitPack](https://jitpack.io/#mohamead/allure-report-api)
(`allureReportApiVersion` in `gradle.properties`, a release tag such as `v1.0.0-SNAPSHOT` by default).
To build against local changes of the API, run `./gradlew publishToMavenLocal` in `allure-report-api` and build the plugin with
`./gradlew buildPlugin -PallureReportApiVersion=1.0.0-SNAPSHOT`.

## License
[apache-2.0](https://choosealicense.com/licenses/apache-2.0/)

---
Plugin built using [IntelliJ Platform Plugin Template][template] and [wrapper][wrapper] of [allure][allure2].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[wrapper]: https://github.com/mohamead/allure-report-api
[allure2]: https://github.com/allure-framework/allure2
