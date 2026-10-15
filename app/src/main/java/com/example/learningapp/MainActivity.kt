package com.example.learningapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/** 一个页面演示：加载布局 → 找到控件 → 响应点击 → 更新文字。 */
class MainActivity : Activity() {
    private var count = 0
    private lateinit var countText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 决定页面上有哪些控件、如何排列。
        setContentView(R.layout.activity_main)

        countText = findViewById(R.id.count_text)
        // 旋转屏幕会重新创建 Activity，从 Bundle 恢复之前的数字。
        count = savedInstanceState?.getInt(KEY_COUNT) ?: 0
        updateCount()

        findViewById<Button>(R.id.increment_button).setOnClickListener {
            count++
            updateCount()
        }
        findViewById<Button>(R.id.reset_button).setOnClickListener {
            count = 0
            updateCount()
        }
    }

    private fun updateCount() {
        // 使用字符串资源里的占位符，而不是在代码中拼接界面文字。
        countText.text = getString(R.string.click_count, count)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNT, count)
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val KEY_COUNT = "click_count"
    }
}
