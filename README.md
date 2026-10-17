# Android 入门：点击计数器

这是一个从最小点击计数器逐步学习大型应用结构的项目。使用 **Kotlin + XML 布局**，已实现的功能只有一个计数器页面；登录、个人中心、设置、网络和数据库仅预留目录，没有接入第三方 UI 框架。

## 运行项目

1. 在电脑上安装 Android Studio，克隆本仓库：
   ```bash
   git clone https://github.com/461c/app1.git
   ```
2. 在 Android Studio 选择 **Open**，打开克隆得到的 `app1` 根目录（不要只打开里面的 `app` 模块）。
3. 将 Gradle JDK 设为 **JDK 17**（Settings → Build, Execution, Deployment → Build Tools → Gradle）。
4. 等待 Gradle Sync 完成。首次运行需要联网下载 Gradle、插件和 Kotlin 依赖。
5. 通过 SDK Manager 安装 **Android SDK Platform 35** 和 **Android SDK Build-Tools 35.0.0**。
6. 在 Device Manager 创建 Android 7.0（API 24）或更高版本的模拟器，或连接已开启 USB 调试的安卓手机。
7. 选择 `app`，点击绿色 ▶ Run。

如果同步失败，先检查网络能否访问 Google Maven、Maven Central 和 Gradle 下载服务，并确认 SDK 与 JDK 配置正确。

## 你会看到什么

- 欢迎文字和当前点击次数。
- 点击“点我 +1”，数字增加。
- 点击“重置”，数字归零。
- 旋转屏幕后保留数字；完全退出后重新打开从 0 开始。本例不做长期存储。

## 从哪里开始读

| 文件 | 学习内容 |
| --- | --- |
| `app/src/main/java/com/example/learningapp/feature/home/ui/MainActivity.kt` | 页面入口、查找控件、按钮事件、保存页面状态 |
| `app/src/main/res/layout/activity_main.xml` | 文字、按钮、间距和垂直布局 |
| `app/src/main/res/values/strings.xml` | 把显示文字集中放在资源文件中 |
| `app/src/main/AndroidManifest.xml` | 注册应用与启动页面 |
| `app/build.gradle.kts` | 应用包名、SDK 和编译设置 |

建议先修改欢迎文字，再修改按钮颜色，最后尝试新增一个“减 1”按钮。

## 命令行构建

安装 JDK 17 和 Android SDK 后，在项目根目录运行：

```bash
# macOS / Linux
./gradlew assembleDebug

# Windows PowerShell
.\gradlew.bat assembleDebug
```

如果找不到 SDK，可先用 Android Studio 打开项目生成本机的 `local.properties`，或自行在该文件中配置 `sdk.dir`。该文件包含本机路径，不提交到 Git。

生成的调试 APK：`app/build/outputs/apk/debug/app-debug.apk`。

## 固定的学习环境

- Android Gradle Plugin 8.9.2
- Gradle Wrapper 8.11.1
- Kotlin 2.1.20
- JDK 17
- compileSdk / targetSdk 35，minSdk 24

这些版本为本学习示例固定配置，不代表最新版本。Gradle Wrapper 脚本和 JAR 来自 Gradle 官方 v8.11.1，保留原始许可信息。

参考：[Android 开发文档](https://developer.android.com/guide)、[AGP 8.9 兼容性说明](https://developer.android.com/build/releases/agp-8-9-0-release-notes)。

## 中文注释与目录说明

每个受版本管理的项目文件夹都有 `文件夹说明.txt`。包含源码或配置的目录还有 `逐行代码说明.txt`，按实际行号解释每条有效代码、XML 属性或配置。

Kotlin、Gradle 配置和 XML 中也已加入中文注释。XML 属性的解释集中放在完整标签之前，避免向标签内部插入注释导致语法错误。空白行和注释本身不参与执行。

官方 `gradlew`、`gradlew.bat` 保留原始内容，逐行中文讲解在根目录 `逐行代码说明.txt`；二进制 JAR 的作用在 `gradle/wrapper/逐行代码说明.txt`。TXT 文档位于资源目录时，应用构建配置会显式排除它们。

从根目录的 `文件夹说明.txt` 开始，可以逐层阅读。说明文档不需要复制到手机上。

## 大应用结构学习版

- 先读 [目录总览](文档/架构说明/目录总览.md) 和 [职责与依赖](文档/架构说明/职责与依赖.md)。
- 首页 Activity 已移动到 `app/src/main/java/com/example/learningapp/feature/home/ui/MainActivity.kt`，清单中的注册位置已同步更新。
- `feature` 按首页、登录、个人中心、设置划分，每个功能预留 `ui`、`domain`、`data`。
- `core` 预留网络、数据库、偏好存储、共享类型、公共组件、小工具；另有 `navigation` 与 `di`。
- 展示了 `debug`、`release`、`test`、`androidTest` 源码集；目前没有新增专用源码或可运行测试。
- 每个文件夹都有《文件夹说明.txt》，原《folder-guide.txt》和《code-guide.txt》已改名为《文件夹说明.txt》和《逐行代码说明.txt》。
- `app` 仍是唯一 Gradle 模块；新增包和目录不是独立的软件或 APK。

新增目录以结构预留为主，不表示对应功能已经实现。继续学习请看 [从计数器到大应用](文档/学习路线/从计数器到大应用.md)。
