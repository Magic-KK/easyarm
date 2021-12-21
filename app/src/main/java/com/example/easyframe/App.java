package com.example.easyframe;

import com.example.easyframe.base.BaseApp;
import net.EasyNet;

public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化网络层
        EasyNet.init(this);
    }
}
