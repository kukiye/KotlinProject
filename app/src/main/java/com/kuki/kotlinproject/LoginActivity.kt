package com.kuki.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.kuki.kotlinproject.api.WanAndroidAPI
import com.kuki.kotlinproject.config.Flag
import com.kuki.kotlinproject.entity.LoginResponse
import com.kuki.kotlinproject.entity.LoginResponseWrapper
import com.kuki.kotlinproject.net.APIClient
import com.kuki.kotlinproject.net.APIResponse
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        user_login_bt.setOnClickListener(clickListener)

    }

    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString();
                val password = user_password_et.text.toString();

                APIClient.instance.instanceRetrofit(WanAndroidAPI::class.java)
                    .login(userName, password)
                    .subscribeOn(Schedulers.io()) // 给上面请求服务器的操作，分配异步线程
                    .observeOn(AndroidSchedulers.mainThread())// 给下面更新UI操作，分配main线程
                    .subscribe(object : APIResponse<LoginResponse>(this) {
                        override fun success(data: LoginResponse?) {
                            // 成功  data UI
                            Log.e(Flag.TAG, "success: $data")
                            Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()
                        }
                        override fun failure(errMsg: String?) {

                            Toast.makeText(this@LoginActivity, "登录失败 ~ 呜呜呜", Toast.LENGTH_SHORT)
                                .show()
                        }

                    })


                /*.subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
                    override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                        // 我这里是更新UI，拿到了包装Bean，实际上我不需要包装Bean


                    }

                })*/


            }

        }


    }
}