// 配置构建插件的解析规则；插件负责给 Gradle 增加 Android、Kotlin 等能力。
pluginManagement {
    // 开始声明依赖下载仓库；Gradle 按这里的顺序查找所需组件。
    repositories {
        // 使用 Google Maven 仓库，下载 Android 构建插件等组件。
        google()
        // 使用 Maven Central 仓库，下载 Kotlin 等开源依赖。
        mavenCentral()
        // 使用 Gradle 官方插件仓库解析插件。
        gradlePluginPortal()
    // 结束下载仓库配置块。
    }
// 结束插件管理块。
}

// 集中管理各模块的普通依赖仓库，与上面的插件仓库分开。
dependencyResolutionManagement {
    // 禁止模块另行声明仓库，所有模块统一使用此处的仓库配置。
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // 开始声明依赖下载仓库；Gradle 按这里的顺序查找所需组件。
    repositories {
        // 使用 Google Maven 仓库，下载 Android 构建插件等组件。
        google()
        // 使用 Maven Central 仓库，下载 Kotlin 等开源依赖。
        mavenCentral()
    // 结束下载仓库配置块。
    }
// 结束依赖解析配置块。
}

// 把 Gradle 项目名称设为 LearningApp；这不是手机桌面显示的应用名称。
rootProject.name = "LearningApp"
// 把 app 文件夹作为一个构建模块加入项目；冒号表示 Gradle 模块路径。
include(":app")
