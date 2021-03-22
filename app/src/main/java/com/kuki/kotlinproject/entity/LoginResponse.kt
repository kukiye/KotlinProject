package com.kuki.kotlinproject.entity

/**
 * "data": {
"admin": false,
"chapterTops": [],
"coinCount": 0,
"collectIds": [],
"email": "",
"icon": "",
"id": 90997,
"nickname": "kuki",
"password": "",
"publicName": "kuki",
"token": "",
"type": 0,
"username": "kuki"
}

登录的实体类
List<*>==>表示List里不知道什么类型
String?==> String值可能为空

 */
data class LoginResponse(
    val admin: Boolean,
    val chapterTops: List<*>,
    val coinCount: Int,
    val collectIds: List<*>,
    val email: String?,
    val icon: String?,
    val id: Int,
    val nickname: String?,
    val password: String?,
    val publicName: String?,
    val token: String?,
    val type: Int,
    val username: String?
) {
}