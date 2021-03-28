package com.kuki.kotlinproject.modules.login

import android.content.Context
import android.util.Log
import com.kuki.kotlinproject.api.WanAndroidAPI
import com.kuki.kotlinproject.config.Flag
import com.kuki.kotlinproject.entity.LoginRegisterResponse
import com.kuki.kotlinproject.modules.login.inter.LoginModule
import com.kuki.kotlinproject.modules.login.inter.LoginPresenter
import com.kuki.kotlinproject.net.APIClient
import com.kuki.kotlinproject.net.APIResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

// Model 层  的 实现
class LoginModelImpl : LoginModule {

    // 取消请求
    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {

        APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)

            // 全部都是RxJava知识了
            .loginAction(username, password)  // 起点  往下流  ”包装Bean“
            .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
            .observeOn(AndroidSchedulers.mainThread()) // 给下面更新UI操作，分配main线程
            .subscribe(object: APIResponse<LoginRegisterResponse>(context)
            {
                override fun success(data: LoginRegisterResponse?) {
                    // 成功  data UI
                    Log.e(Flag.TAG, "success: $data")
                    onLoginListener.loginSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    // 失败 msg UI
                    Log.e(Flag.TAG, "failure: errorMsg:$errorMsg")
                    onLoginListener.loginFialure(errorMsg)
                }

            })

    }


}