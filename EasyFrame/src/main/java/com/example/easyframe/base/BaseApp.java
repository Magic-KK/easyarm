package com.example.easyframe.base;

import android.app.Application;

import com.example.easyframe.net.EasyNet;
import com.example.easyframe.utils.EasyLog;
import com.example.easyframe.utils.EasyMMKV;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Log初始化
        EasyLog.init();
        //初始化MKKV
        EasyMMKV.init(this);
        //初始化网络层
        EasyNet.init();

    }
}
