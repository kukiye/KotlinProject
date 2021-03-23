package com.kuki.kotlinproject

import android.content.Context
import com.kuki.kotlinproject.entity.LoginResponse
import com.kuki.kotlinproject.mvp.LoginPresenter
import com.kuki.kotlinproject.mvp.LoginPresenter.LoginListener
import com.kuki.kotlinproject.mvp.LoginView

//LoginPresenter 的实现类
class LoginPresenterImpl constructor(var loginView: LoginView) : LoginPresenter, LoginListener {


    var modelImpl: LoginModelImpl = LoginModelImpl();


    override fun loginAction(context: Context, userName: String, password: String) {

        modelImpl.loginAction(context, userName, password, this);
    }

    override fun loginSuccess(loginResponse: LoginResponse?) {
        loginView.loginSuccess(loginResponse);
    }

    override fun loginFail(errMsg: String?) {
        loginView.loginFail(errMsg);
    }
}