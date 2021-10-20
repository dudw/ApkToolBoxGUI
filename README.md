# ApkToolBoxGUI

![Java CI with Maven](https://github.com/jiangxincode/ApkToolBoxGUI/workflows/Java%20CI%20with%20Maven/badge.svg)
[![Project Documentation](https://img.shields.io/badge/Aloys-Project%20Documentation-green.svg)](https://jiangxincode.github.io/ApkToolBoxGUI)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jiangxincode_ApkToolBoxGUI&metric=alert_status)](https://sonarcloud.io/dashboard?id=jiangxincode_ApkToolBoxGUI)
[![Travis CI Build Status](https://travis-ci.org/jiangxincode/ApkToolBoxGUI.svg?branch=master)](https://travis-ci.org/jiangxincode/ApkToolBoxGUI)
[![Code Climate Maintainability](https://api.codeclimate.com/v1/badges/fb8d289a4b0ee14f9d8b/maintainability)](https://codeclimate.com/github/jiangxincode/ApkToolBoxGUI/maintainability)
[![Code Climate Test Coverage](https://api.codeclimate.com/v1/badges/fb8d289a4b0ee14f9d8b/test_coverage)](https://codeclimate.com/github/jiangxincode/ApkToolBoxGUI/test_coverage)
[![Coverage Status](https://coveralls.io/repos/github/jiangxincode/ApkToolBoxGUI/badge.svg?branch=master)](https://coveralls.io/github/jiangxincode/ApkToolBoxGUI?branch=master)
[![Release Version](https://img.shields.io/github/v/release/jiangxincode/ApkToolBoxGUI?include_prereleases&sort=semver)](https://github.com/jiangxincode/ApkToolBoxGUI/releases/latest)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/19016/badge.svg)](https://scan.coverity.com/projects/jiangxincode-apktoolboxgui)


A open source tool for simplify android development. It targets to replace all features of these tools:

* ApkToolBox(C#): <https://github.com/qtfreet00/ApkToolBox>
* ApkToolBox(PowerShell): <https://github.com/jiangxincode/ApkToolBox>
* APKDB(安卓逆向助手): <https://bitbucket.org/idoog/apkdb/downloads/>
* APKIDE(改之理): <http://hrtsea.com/15759.html>
* ApkToolkit: <https://www.52pojie.cn/thread-263925-1-1.html>
* Android Killer: <https://www.52pojie.cn/thread-319641-1-1.html>
* I18NTools(**All features have been replaced**): <https://github.com/jiangxincode/I18NTools>
* TextTools(**All main features have been replaced**): <https://github.com/jiangxincode/TextTools>
* 元宝文件编码转换器(**All features have been replaced**): <http://www.jz5u.com/Soft/apply/Conve/131917.html>
* UltraCodingSwitch(**All main features have been replaced**): <https://www.jb51.net/softs/21331.html>

## Why you should try

* Open source forever
* More powerful features
* Easier to use
* Update more frequently

## Features

### Reverse

### SnapShot

### Dumpsys

* adb shell dumpsys alarm

### Test

### Text

* Convert between different character encodings
* Convert between different OS types
* Convert between Simplified Chinese and Traditional Chinese

### File

* Find duplicated files

ref: <https://github.com/vivekbhalla/DuplicateFileFinder>

### Time

* Transform between timestamp and formatted time

### I18N

* Copy or replace some `<string />` in strings.xml in the `value[.*]` directory of the [A directory] to the strings.xml in the `value[.*]` directory of the [B directory]. It is mainly used to merge translations into several code branches.
* Find the longest translation of a `<string />`. Primarily for finding cuts or line breaks.

## License

* Apache License V2.0 <http://www.apache.org/licenses/LICENSE-2.0>

## Contributing

Any contributing is welcomed.

1. Fork repository
2. Make changes
3. Ensure tests pass (or hopefully adding tests!)
4. Submit pull request/issue

* build binary: mvn clean package
* build project documentation: mvn clean package site

## Dependencies

| Name | Version | Website | License
| ------ | ------ | ------ | ------ |
| Apktool | v2.5.0 | <https://github.com/iBotPeaches/Apktool> | Apache 2.0 |
| GD-GUI | 1.6.6 | <http://jd.benow.ca> | GNU GPL v3 |
| JADX-GUI | v1.2.0 | <https://github.com/skylot/jadx> | Apache 2.0 |
| ApkSigner | 1.3 | <http://apk.aq.163.com/apkpack.do#download> | Apache 2.0 |
| AXMLPrinter3 | 0.0.1-SNAPSHOT | <https://github.com/jiangxincode/AXMLPrinter3> | Apache 2.0 |

## Contributors

All contributors will be listed here.

* Jiangxin <jiangxinnju@gmail.com>
