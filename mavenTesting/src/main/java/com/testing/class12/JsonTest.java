package com.testing.class12;

import com.alibaba.fastjson2.JSONObject;

public class JsonTest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("czy","懒阳阳");
        System.out.println(jsonObject);
    }
}
