package com.kuki.kotlinproject.modules.register.inter

import android.content.Context
import com.kuki.kotlinproject.base.IBasePresenter
import com.kuki.kotlinproject.entity.LoginRegisterResponse

interface RegisterPersenter : IBasePresenter {

    fun registerWanAndroid(context: Context, username: String, password: String, repassword: String)

    // M  ---》 P  接口监听
    interface OnRegisterListener {

        fun registerSuccess(registerBean: LoginRegisterResponse?)

        fun registerFailed(errorMsg: String?)

    }

}