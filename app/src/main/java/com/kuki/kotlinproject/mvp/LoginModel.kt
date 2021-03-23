package com.kuki.kotlinproject.mvp

import android.content.Context

/**
 * 跟数据打交道，需要去网络请求数据
 */
interface LoginModel {

    // 取消请求 动作
    fun cancelRequest()

    // 登录
    fun loginAction(
        context: Context,
        userName: String,
        password: String,

        // 接口回调，把data 结果，给P层
        loginListener: LoginPresenter.LoginListener
    )

}