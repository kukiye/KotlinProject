package com.kuki.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kuki.kotlinproject.entity.LoginResponse
import com.kuki.kotlinproject.mvp.LoginView
import kotlinx.android.synthetic.main.activity_login.*

//LoginView 的实现类
class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var presenter: LoginPresenterImpl;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        user_login_bt.setOnClickListener(clickListener)

        presenter = LoginPresenterImpl(this);

    }

    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString();
                val password = user_password_et.text.toString();

                presenter.loginAction(this@LoginActivity, userName, password)
            }

        }


    }

    override fun loginSuccess(loginResponse: LoginResponse?) {
        Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()

    }

    override fun loginFail(errMsg: String?) {
        Toast.makeText(this@LoginActivity, "登录失败 ~ $errMsg", Toast.LENGTH_SHORT)
            .show()
    }
}