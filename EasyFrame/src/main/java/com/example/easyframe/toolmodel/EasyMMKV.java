package com.example.easyframe.toolmodel;


import android.content.Context;
import com.tencent.mmkv.MMKV;

/**
 * MMKV 键值对存储工具
 */
public class EasyMMKV {

    public static void save(String sp, String key, String value) {
        MMKV.mmkvWithID(sp).encode(key, value);
    }

    public static void save(String sp, String key, int value) {
        MMKV.mmkvWithID(sp).encode(key, value);
    }

    public static String getString(String sp, String key) {
        return MMKV.mmkvWithID(sp).decodeString(key);
    }

    public static String getString(String sp, String key, String defaultValue) {
        return MMKV.mmkvWithID(sp).decodeString(key, defaultValue);
    }

    public static int getInt(String sp, String key) {
        return MMKV.mmkvWithID(sp).decodeInt(key);
    }

    public static int getInt(String sp, String key, int defaultValue) {
        return MMKV.mmkvWithID(sp).decodeInt(key, defaultValue);
    }

    public static void clear(String sp) {
        MMKV.mmkvWithID(sp).clearAll();
    }

    public static void removeKey(String sp, String key) {
        MMKV.mmkvWithID(sp).remove(key);
    }
}
