package com.beibei.init.common.utils;

import com.google.gson.Gson;

/**
 * Created by dashen10 on 2015/8/12.
 */
public class GsonUtils {
    /**
     * 解析json
     * @param json 要解析的json
     * @param cls javabean
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> cls) {
        Gson gson = new Gson();
        return gson.fromJson(json,cls);
    }

    /**
     * 生成json
     * @param obj 要生成的数据
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
