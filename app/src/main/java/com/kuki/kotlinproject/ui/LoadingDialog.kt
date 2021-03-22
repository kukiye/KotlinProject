package com.kuki.kotlinproject.ui

import android.app.Dialog
import android.content.Context
import com.kuki.kotlinproject.R

// 加载框
// object 没有主构造 也没有次构造 单例模式
object LoadingDialog {

    private var dialog: Dialog? = null

    fun show(context: Context) {
        cancel();

        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()

    }

    fun cancel() {
        dialog?.dismiss()
    }

}