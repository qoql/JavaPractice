package com.example.JavaPractice.scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JsonParsetDemo {

    public static void testJson() {
        //创建一个
        JSONObject object = new JSONObject();
        //string
        object.put("string","string");
        //int
        object.put("int",2);
        //boolean
        object.put("boolean",true);
        //array
        List<Integer> integers = Arrays.asList(1,2,3);
        object.put("list",integers);
        //null
        object.put("null",null);
        System.out.println(object);
    }

    public void testJson2() {
        JSONObject object = JSONObject
                .parseObject("{\"boolean\":true,\"string\":\"string\",\"list\":[1,2,3],\"int\":2}");
        //string
        String s = object.getString("string");
        System.out.println(s);
        //int
        int i = object.getIntValue("int");
        System.out.println(i);
        //boolean
        boolean b = object.getBooleanValue("boolean");
        System.out.println(b);
        //list
        List<Integer> integers = JSON.parseArray(object.getJSONArray("list").toJSONString(),Integer.class);
        integers.forEach(System.out::println);
        //null
        System.out.println(object.getString("null"));
    }



}
