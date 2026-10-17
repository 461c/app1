// 声明首页界面的代码包，对应 com/example/learningapp/feature/home/ui 目录。
package com.example.learningapp.feature.home.ui

// 引入 Android 的 Activity 类；Activity 是承载应用页面的组件。
import android.app.Activity
// 引入 Bundle，用键值对保存、传递少量页面状态。
import android.os.Bundle
// 引入按钮控件类型 Button。
import android.widget.Button
// 引入显示文字的控件类型 TextView。
import android.widget.TextView
// R 资源类仍由 app 模块的 namespace 生成；页面换包后需要显式导入。
import com.example.learningapp.R

/** 一个页面演示：加载布局 → 找到控件 → 响应点击 → 更新文字。 */
// 定义 MainActivity 页面类，冒号表示继承 Activity；花括号内是这个类的内容。
class MainActivity : Activity() {
    // 定义仅在类内部使用的可变整数 count，初始值为 0，记录点击次数。
    private var count = 0
    // 声明稍后初始化的文字控件；布局加载后才能赋值，使用前必须完成初始化。
    private lateinit var countText: TextView

    // 重写页面创建回调；Bundle? 表示参数可为空，首次创建一般为空，重建时可能含旧状态。
    override fun onCreate(savedInstanceState: Bundle?) {
        // 先执行父类 Activity 的初始化逻辑，并传入保存的状态。
        super.onCreate(savedInstanceState)
        // XML 决定页面上有哪些控件、如何排列。
        // 加载 res/layout/activity_main.xml，建立当前页面的控件树。
        setContentView(R.layout.activity_main)

        // 根据布局中定义的 ID 找到计数文字控件，保存到 countText。
        countText = findViewById(R.id.count_text)
        // 旋转屏幕会重新创建 Activity，从 Bundle 恢复之前的数字。
        // ?. 表示状态非空时才读取整数；?: 表示结果为空时用 0，恢复页面重建前的计数。
        count = savedInstanceState?.getInt(KEY_COUNT) ?: 0
        // 调用下方定义的函数，让界面上的数字与 count 的值保持一致。
        updateCount()

        // 找到加一按钮并注册点击回调；花括号中的代码会在用户点击时执行。
        findViewById<Button>(R.id.increment_button).setOnClickListener {
            // 将 count 的值加 1，等价于 count = count + 1。
            count++
            // 调用下方定义的函数，让界面上的数字与 count 的值保持一致。
            updateCount()
        // 结束加一按钮的点击回调。
        }
        // 找到重置按钮并注册点击回调。
        findViewById<Button>(R.id.reset_button).setOnClickListener {
            // 把计数变量重新设置为 0。
            count = 0
            // 调用下方定义的函数，让界面上的数字与 count 的值保持一致。
            updateCount()
        // 结束重置按钮的点击回调。
        }
    // 结束onCreate 页面创建函数。
    }

    // 定义类内部使用的更新界面函数，把重复的显示逻辑集中到一处。
    private fun updateCount() {
        // 使用字符串资源里的占位符，而不是在代码中拼接界面文字。
        // 读取 click_count 字符串，把 count 填入 %1$d 占位符，再设置到控件的 text 属性。
        countText.text = getString(R.string.click_count, count)
    // 结束updateCount 文字更新函数。
    }

    // 重写保存临时页面状态的回调；系统在需要时提供 Bundle，用于之后重建页面。
    override fun onSaveInstanceState(outState: Bundle) {
        // 以 KEY_COUNT 为键保存整数 count，便于 onCreate 按同一个键读取。
        outState.putInt(KEY_COUNT, count)
        // 让父类继续保存系统管理的页面和控件状态。
        super.onSaveInstanceState(outState)
    // 结束onSaveInstanceState 状态保存函数。
    }

    // 声明伴生对象，用来放与类关联的常量等成员。
    companion object {
        // 定义编译期常量，统一保存和读取 Bundle 时使用的键名，避免拼写不一致。
        private const val KEY_COUNT = "click_count"
    // 结束伴生对象。
    }
// 结束MainActivity 类。
}
