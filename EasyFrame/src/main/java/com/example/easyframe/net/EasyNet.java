package com.example.easyframe.net;

import rxhttp.RxHttpPlugins;
import rxhttp.wrapper.annotation.DefaultDomain;
import rxhttp.wrapper.cahce.CacheMode;

public class EasyNet {

    @DefaultDomain //设置为默认域名
    public static String baseUrl = "https://www.wanandroid.com/";

    public static void init() {
        RxHttpPlugins.init(null)      //自定义OkHttpClient对象
                .setDebug(true);
        //是否开启调试模式，开启后，logcat过滤RxHttp，即可看到整个请求流程日志
    }
}
