package com.kuki.kotlinproject.api

import com.kuki.kotlinproject.entity.LoginResponse
import com.kuki.kotlinproject.entity.LoginResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// 客户端API 可以访问 服务器的API
interface WanAndroidAPI {


    /**
     * 登录API
     * username=Derry-vip&password=123456
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<LoginResponseWrapper<LoginResponse>>

}