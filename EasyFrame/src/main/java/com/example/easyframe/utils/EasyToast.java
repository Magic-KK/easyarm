package com.example.easyframe.utils;

import android.app.Application;
import android.content.Context;
import com.hjq.toast.ToastUtils;

public class EasyToast {
    public static void initToast(Application context) {
        ToastUtils.init(context);
    }

    public static void show(String text) {
        ToastUtils.show(text);
    }

    public static void show(int text) {
        ToastUtils.show(text);
    }

}
