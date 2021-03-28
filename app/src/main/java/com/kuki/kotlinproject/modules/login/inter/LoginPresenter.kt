package com.kuki.kotlinproject.modules.login.inter

import android.content.Context
import com.kuki.kotlinproject.base.IBasePresenter
import com.kuki.kotlinproject.entity.LoginRegisterResponse

// Presenter 层
interface LoginPresenter : IBasePresenter {

    // 登录
    fun loginAction(context: Context, username: String, password: String)

    // 监听回调
    interface OnLoginListener {

        fun loginSuccess(loginBean: LoginRegisterResponse?)

        fun loginFialure(erroeMsg: String  ?)

    }

}