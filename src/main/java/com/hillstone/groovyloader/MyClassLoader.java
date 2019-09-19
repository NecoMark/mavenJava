package com.hillstone.groovyloader;

import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author: ljyang
 * @date: 2019/9/10 17:03
 * @description
 */

public class MyClassLoader extends ClassLoader {
    static HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        System.out.println(hashMap.size());
    }
}

