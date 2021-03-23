package com.kuki.kotlinproject.mvp

import android.content.Context
import com.kuki.kotlinproject.entity.LoginResponse

interface LoginPresenter {

    // 登录
    fun loginAction(
        context: Context,
        userName: String,
        password: String
    )

    // 监听回调
    interface LoginListener {

        fun loginSuccess(loginResponse: LoginResponse?)
        fun loginFail(errMsg: String?)
    }


}