package com.example.easyframe;

import com.example.easyframe.base.BaseApp;
import net.EasyNet;

public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        // BaseApp 已完成日志、Toast、MMKV 初始化；示例应用只需补充网络层配置。
        EasyNet.init(this);
    }
}
