# ![allure-report-plugin](./src/main/resources/META-INF/pluginIcon.svg) Allure Report

![Build](https://github.com/mohamead/allure-report-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/24074)](https://plugins.jetbrains.com/plugin/24074-allure-report/versions)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/24074)](https://plugins.jetbrains.com/plugin/24074-allure-report)

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

The plugin is developed without the need of allure being installed. Once the plugin is installed it will allow us to perform 
allure's **generate**, **open** and **serve** command on specific folders.

**Generate**: A pre-request in order to use this command is that the folder-name must contain the value `allure-results`. 

![Image Alt text](/images/Generate.png)

![Image Alt text](/images/Allure.png)

**Open**: A pre-request is that the folder-name must contain the value `allure-report`.

**Serve**: A pre-request is that the folder-name must contain one of the following names `allure-results`, `surefire-reports` or `failsafe-reports`

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[apache-2.0](https://choosealicense.com/licenses/apache-2.0/)

---
Plugin built using [IntelliJ Platform Plugin Template][template] and [forked version][fork] of [allure][allure2].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[fork]: https://github.com/mohamead/allure2
[allure2]: https://github.com/allure-framework/allure2
