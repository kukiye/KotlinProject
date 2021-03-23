package com.kuki.kotlinproject.mvp

import com.kuki.kotlinproject.entity.LoginResponse

interface LoginView {

    fun loginSuccess(loginResponse: LoginResponse?)
    fun loginFail(errMsg: String?)

}