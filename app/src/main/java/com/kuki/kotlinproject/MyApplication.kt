package com.kuki.kotlinproject

import android.app.Application
import android.util.Log
import com.kuki.kotlinproject.config.Flag
import com.kuki.kotlinproject.databse.StudentDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(Flag.TAG, "MyApplication onCreate run")

        // 初始化
        StudentDatabase.getDatabase(this)
    }

}