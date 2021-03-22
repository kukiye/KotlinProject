package com.kuki.kotlinproject.entity


/**
 * 登录的包装Bean
 *
 * {
"data": {
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
},
"errorCode": 0,
"errorMsg": ""
}

登录失败 Response 结果信息：
{
"data": null,
"errorCode": -1,
"errorMsg": "账号密码不匹配！"
}
 *
 * data class ==》 Kotlin中的data bean 省略了set,get
 * val==>只读，不能写，改变值  相当于常量，底层Java代码是被final修饰
 * var==>可读可写，相当于变量
 */
data class LoginResponseWrapper<T>(val data: T, val errorCode: Int, val errorMsg: String) {
}