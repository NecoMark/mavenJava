package com.hillstone.groovyloader;

import com.alibaba.fastjson.JSONObject;

import java.io.File;

import static com.hillstone.groovyloader.GroovyLoad.groovyClassLoader;

/**
 * @author: ljyang
 * @date: 2019/9/10 8:47
 * @description
 */

public class GroovyClass1 {
    public void print(){
        String str = "{\"app\": \"123\"}";
        JSONObject.parseObject(str);
//        Class<?> javaClass = null;
//        try {
//            javaClass = groovyClassLoader.parseClass(new File());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("javaClass" + javaClass.getClassLoader());

        GroovyClass2 groovyClass2 = new GroovyClass2();
        System.out.println("222" + groovyClass2.getClass().getClassLoader());

        System.out.println("hello");
    }
}
