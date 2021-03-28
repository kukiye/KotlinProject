package com.xiangxue.lib.java;

import com.xiangxue.lib.java.cb.JavaCallback;
import com.xiangxue.lib.java.cb.JavaManager;
import com.xiangxue.lib.kt.cb.KTCallback;
import com.xiangxue.lib.kt.cb.KtManager;

import org.jetbrains.annotations.NotNull;



public class Client {


    public static void main(String[] args) {

      /*  MyUtilsKt.show("Derry1");

        new MyUtils().show("new Derry2");*/

        new JavaManager().setCallback(new JavaCallback() {
            @Override
            public void show(String info) {
                System.out.println("info=="+info);

            }
        });


        new KtManager().setCallback(new KTCallback() {
            @Override
            public void show(@NotNull String name) {
                System.out.println("name=="+name);

            }
        });

    }

}
