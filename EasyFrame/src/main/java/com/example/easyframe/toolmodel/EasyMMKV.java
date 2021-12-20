package com.example.easyframe.toolmodel;


import android.content.Context;
import com.tencent.mmkv.MMKV;

/**
 * MMKV 键值对存储工具
 */
public class EasyMMKV {

    static MMKV kv = null;

    /**
     * 初始化 MMKV
     *
     * @param context
     */
    public static void init(Context context) {
        MMKV.initialize(context);
        kv = MMKV.defaultMMKV();
    }

    public static void save(String key, String value) {
        kv.encode(key, value);
    }

    public static String getString(String key) {
        return kv.decodeString(key);
    }

    public static String getString(String key, String defaults) {
        return kv.decodeString(key, defaults);
    }

}
