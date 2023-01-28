package com.example.JavaPractice.scheduled;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class JsonParset {
    public static void main(String[] args) throws IOException {
//        testJson();
        testJson2();
    }

    public static void testJson() {
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

    public static void testJson2() throws IOException {
        String s1 = readFile();
        JSONObject object = JSONObject
                .parseObject(s1);
        //string
        String s = object.getString("res");
        System.out.println(s);
        //int
        int i = object.getIntValue("int");
        System.out.println(i);
        //boolean
        boolean b = object.getBooleanValue("boolean");
        System.out.println(b);
    }

    private static String readFile() throws IOException {
        File file = new File("C:\\Users\\40346\\Desktop\\json.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        StringBuffer sb = new StringBuffer();
        String str = null;
        while (inputStreamReader.ready()){
            sb.append((char) inputStreamReader.read());
        }
        str = sb.toString();
        return str;
    }


}
