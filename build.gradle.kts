// 插件版本统一放在根目录，app 模块只需要引用。
// 开始声明本构建脚本需要的插件。
plugins {
    // 固定 Android 应用插件版本；apply false 表示这里只声明版本，不在根项目应用。
    id("com.android.application") version "8.9.2" apply false
    // 固定 Kotlin Android 插件版本，实际应用插件的位置是 app 模块。
    id("org.jetbrains.kotlin.android") version "2.1.20" apply false
// 结束插件声明块。
}
