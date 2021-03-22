package com.kuki.kotlinproject.net

import android.content.Context
import com.kuki.kotlinproject.entity.LoginResponse
import com.kuki.kotlinproject.entity.LoginResponseWrapper
import com.kuki.kotlinproject.ui.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer


// RxJava 自定义 操作符 简单的
// 拦截 自定义操作符，目的: 包装Bean 给拆成两份
abstract class APIResponse<T>(val context: Context) //主构造函数
    : Observer<LoginResponseWrapper<T>> {


    private var isShowLoadingDialog: Boolean = true

    //次构造函数  需要调用主构造函数
    constructor(context: Context, isShowLoadingDialog: Boolean) : this(context) {
        this.isShowLoadingDialog = isShowLoadingDialog;
    }


    abstract fun success(data: T?)
    abstract fun failure(errMsg: String?)

    // 起点 分发的时候
    override fun onSubscribe(d: Disposable) {
        if(isShowLoadingDialog){
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: LoginResponseWrapper<T>) {
        if (t.data != null) {
            success(t.data);
        } else {
            failure(t.errorMsg)
        }
    }

    // 上游流下了的错误
    override fun onError(e: Throwable) {
        // 取消加载
        LoadingDialog.cancel()

        failure(e.message)
    }

    override fun onComplete() {
        // 取消加载
        LoadingDialog.cancel()
    }


}