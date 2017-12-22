package com.mt.utils;

import net.sf.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class VenderUtils {

    public static String returnToJson(int code, String msg, Object data){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return JSONArray.fromObject(map).toString();
    }
}
