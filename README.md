# ![allure-report-plugin](./src/main/resources/META-INF/pluginIcon.svg) Allure Report

![Build](https://github.com/mohamead/allure-report-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
Unofficial plugin that wraps the following [allure2] commands:
- Generate any **allure-report** from **allure-results**
- Open any **allure-report**
- Serve any **allure-results**, **surefire-reports** or **failsafe-reports**
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

**Generate**: A pre-request in order to use this command is that the folder must be named `allure-results`. 

![Image Alt text](/images/Generate.png "Optional title")

**Open**: A pre-request is that the folder-name is `allure-report`.

**Serve**: A pre-request is that the folder-name is one of `allure-results`, `surefire-reports` or `failsafe-reports`

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[apache-2.0](https://choosealicense.com/licenses/apache-2.0/)

---
Plugin built using [IntelliJ Platform Plugin Template][template] and [forked version][fork] of [allure2].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[fork]: https://github.com/mohamead/allure2
[allure2]: https://github.com/allure-framework/allure2
