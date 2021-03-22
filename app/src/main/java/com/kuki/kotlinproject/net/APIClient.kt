package com.kuki.kotlinproject.net

import com.kuki.kotlinproject.config.Flag
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.attribute.AclEntry.newBuilder
import java.util.concurrent.TimeUnit

/**
 * 访问服务器的API接口(WanAndroidAPI) 的 客户端管理
 */
class APIClient {

    //单例模式
    object Holder {
        val INSTANCE = APIClient()
    }

    //伴生
    companion object {
        val instance = Holder.INSTANCE
    }

    // WanAndroidAPI实例化这个，  XXXAPI实例化这个，   BBBAPI实例化
    //传入参数T，返回参数T ，T为WanAndroidAPI实例
    fun <T> instanceRetrofit(apiInstance: Class<T>): T {

        val mOkHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            // 添加读取超时时间
            .readTimeout(10000, TimeUnit.SECONDS)

            // 添加连接超时时间
            .connectTimeout(10000, TimeUnit.SECONDS)

            // 添加写出超时时间
            .writeTimeout(10000, TimeUnit.SECONDS)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            // 请求方  ←
            .baseUrl(Flag.BASE_URL)
            .client(mOkHttpClient)

            // 响应方  →
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // RxJava来处理
            .addConverterFactory(GsonConverterFactory.create()) // Gson 来解析 --- JavaBean
            .build();
        return retrofit.create(apiInstance);

    }


}