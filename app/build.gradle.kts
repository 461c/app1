// 开始声明本构建脚本需要的插件。
plugins {
    // 在 app 模块应用 Android 插件，使它能够编译资源、代码并生成 APK。
    id("com.android.application")
    // 在 app 模块应用 Kotlin 插件，使 Gradle 能编译 .kt 文件。
    id("org.jetbrains.kotlin.android")
// 结束插件声明块。
}

// 开始配置这个 Android 模块的构建参数。
android {
    // 设置生成的 R 资源类等代码所在的命名空间，代码通过 R.layout、R.id 使用资源。
    namespace = "com.example.learningapp"
    // 使用 Android API 35 的接口编译；它本身不决定最低可运行版本。
    compileSdk = 35

    // 开始声明所有构建变体共用的应用配置。
    defaultConfig {
        // 设置设备和应用商店用来识别本应用的唯一标识；正式发布时应改成自己的名称。
        applicationId = "com.example.learningapp"
        // 最低支持 API 24，也就是 Android 7.0。
        minSdk = 24
        // 声明应用按 API 35 的行为规则适配；系统会据此启用相关兼容行为。
        targetSdk = 35
        // 内部版本号；将来发布更新时需要递增。
        versionCode = 1
        // 面向用户显示的版本名称。
        versionName = "1.0"
    // 结束默认应用配置块。
    }

    // 开始配置 Android 资源处理规则；下面的规则让资源目录可以放学习用 TXT。
    androidResources {
        // 保留常见默认忽略规则，并排除 folder-guide.txt、code-guide.txt，防止说明文档参与资源编译；冒号分隔匹配规则。
        ignoreAssetsPattern = "!.svn:!.git:!.ds_store:!*.scc:.*:<dir>_*:!CVS:!thumbs.db:!picasa.ini:!*~:!folder-guide.txt:!code-guide.txt"
    // 结束资源处理配置块。
    }

    // 开始配置 Java 源码和编译输出的语言版本。
    compileOptions {
        // Java 源文件按 Java 17 语法级别编译。
        sourceCompatibility = JavaVersion.VERSION_17
        // Java 编译结果使用 Java 17 字节码级别，Android 工具随后将其转成 DEX。
        targetCompatibility = JavaVersion.VERSION_17
    // 结束Java 编译配置块。
    }
    // 开始配置 Kotlin 编译器的相关选项。
    kotlinOptions {
        // Kotlin 生成 Java 17 级别的 JVM 字节码，与 Java 配置保持一致。
        jvmTarget = "17"
    // 结束Kotlin 编译配置块。
    }
// 结束Android 配置块。
}
