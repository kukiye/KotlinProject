package com.kuki.kotlinproject.modules.collect.inter

import com.kuki.kotlinproject.databse.Student

interface CollectView {

    // 显示数据  --- 》 View

    fun showResultSuccess(result: List<Student> ?)

    fun showResult(result: Boolean)
}