package com.example.easyframe.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EasyGsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private EasyGsonUtil() {
    }

    /**
     * 转成json
     */
    public static String gsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            try {
                gsonString = gson.toJson(object);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return gsonString;
    }

    /**
     * 转成bean
     */
    public static <T> T gsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            try {
                t = gson.fromJson(gsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 转成bean
     */
    public static <T> T gsonToBean(String gsonString, Type typeOfT) {
        T t = null;
        if (gson != null) {
            try {
            t = gson.fromJson(gsonString, typeOfT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 转成list
     * 解决泛型问题
     */
    public static <T> List<T> gsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        try {
            JsonArray array = new JsonParser().parse(json).getAsJsonArray();
            for (final JsonElement elem : array) {
                list.add(gson.fromJson(elem, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 转成list中有map的
     */
    public static <T> List<Map<String, T>> gsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            try {
                list = gson.fromJson(gsonString,
                        new TypeToken<List<Map<String, T>>>() {
                        }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 转成map的
     */
    public static <T> Map<String, T> gsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            try {
                map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 转成帶List的map的
     */
    public static <T> Map<String, List<T>> gsonToMapLists(String gsonString) {
        Map<String, List<T>> map = null;
        if (gson != null) {
            try {
                map = gson.fromJson(gsonString, new TypeToken<Map<String, List<T>>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
