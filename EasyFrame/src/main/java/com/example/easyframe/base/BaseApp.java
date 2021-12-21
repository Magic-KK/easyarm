package com.example.easyframe.base;

import android.app.Application;

import com.example.easyframe.toolmodel.EasyLog;
import com.example.easyframe.toolmodel.EasyMMKV;
import com.example.easyframe.toolmodel.EasyToast;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public void init() {
        //Log初始化
        EasyLog.init();
        //初始化MKKV
        EasyMMKV.init(this);
        //初始化Toast
        EasyToast.initToast(this);
    }
}
