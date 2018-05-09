package com.example.yyh.canvesdemo;

import android.webkit.JavascriptInterface;

/**
 * Created by yuhong.yang on 2018/3/15.
 */

public class JavaInterface {

    @JavascriptInterface
    public String back(){
        return "这是原生back函数返回的内容";

    }
}
