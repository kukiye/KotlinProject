package com.xiangxue.lib.core

fun main() {

    //  ()->Unit ==>空参函数并且没有返回值
    /* var method01:()->Unit
     //没有具体的实现，所以不能调用
     method01()

    var method02: (Int, Int) -> Int
    method02(9, 9)

    var method03: (String, Double) -> Any?
    method03("Derry", 42393.5)

    var method04: (Int, Double, Long, String?) -> Boolean
    method04(1, 22, 33, null)

    var method05: (Int, Int) -> Int
    method05(9, 9)*/

    // TODO 定义没有问题，调用OK ，因为有实现了
    var m06: (Int, Int) -> Int = { number1, number2 -> number1 + number2 }
    m06(9, 9)
    println("m06:${m06(9, 9)}")

    var m07 = { number01: Int, number02: Int -> number01.toDouble() + number02.toDouble() }
    println("m07:${m07(10, 10)}")

    var m08: (String, String) -> Unit = { aString, bString ->
        println("a:$aString ,b:$bString")
    }
    m08("李元霸", "王五")

    var m09: (String) -> String = { str -> str }
    println("m09:${m09("降龙十八掌")}")

    var m10: (Int) -> Unit = {
        when (it) {
            1 -> println("你是一")
            in 20..30 -> println("你是 二十 到 三十")
            else -> println("其他的数字")
        }
    }
    m10(25)

    var m11 = { n1: Int, n2: Int, n3: Int -> println("n1:$n1,n2:$n2,n3:$n3") }
    m11(11, 34, 67)

    var m12 = { println("我就是m12函数，我就是我") }
    m12()

    val m13 = { sex: Char -> if (sex == 'M') "代表是男的" else "代表是女的" }
    println("m13:${m13('M')}")

    //覆盖操作
    var m14 = { number: Int -> println("我就是m14  我的参数: $number") }
    m14 = { println("覆盖 我的参数：$it") }
    m14(57)

    // 需求：我想打印， 并且，我还想返回值，就是 我什么都想要
    var m15: (number1: Int) -> Int = {
        println("啦啦啦number:$it")
        it + 4677
    }
    println("m15:${m15(477)}")


}