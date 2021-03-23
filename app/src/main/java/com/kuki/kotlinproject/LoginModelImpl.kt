package com.kuki.kotlinproject

import android.content.Context
import android.util.Log
import com.kuki.kotlinproject.api.WanAndroidAPI
import com.kuki.kotlinproject.config.Flag
import com.kuki.kotlinproject.entity.LoginResponse
import com.kuki.kotlinproject.mvp.LoginModel
import com.kuki.kotlinproject.mvp.LoginPresenter
import com.kuki.kotlinproject.net.APIClient
import com.kuki.kotlinproject.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//LoginModule 的实现类
class LoginModelImpl : LoginModel {
    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun loginAction(
        context: Context,
        userName: String,
        password: String,
        loginListener: LoginPresenter.LoginListener
    ) {

        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
            .login(userName, password)
            .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
            .observeOn(AndroidSchedulers.mainThread())// 给下面更新UI操作，分配main线程
            .subscribe(object : APIResponse<LoginResponse>(context) {
                override fun success(data: LoginResponse?) {
                    // 成功  data UI
                    Log.e(Flag.TAG, "success: $data")

                    loginListener?.loginSuccess(data)
                }

                override fun failure(errMsg: String?) {
                    loginListener?.loginFail(errMsg)
                }

            })


        /*.subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
            override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                // 我这里是更新UI，拿到了包装Bean，实际上我不需要包装Bean


            }

        })*/


    }
}