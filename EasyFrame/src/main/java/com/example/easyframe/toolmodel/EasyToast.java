package com.example.easyframe.toolmodel;

import android.app.Application;
import com.hjq.toast.Toaster;

public class EasyToast {
    public static void initToast(Application context) {
        Toaster.init(context);
    }

    public static void show(String text) {
        Toaster.show(text);
    }

    public static void show(int text) {
        Toaster.show(text);
    }

}
