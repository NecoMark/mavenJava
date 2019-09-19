package com.hillstone.Generics;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ljyang
 * @date: 2019/9/5 16:35
 * @description
 */

public class GenericsDemo {
    public static void main(String[] args) {
        /**
         * list1指针可能指向List<Fruit>,也可能指向List<Apple>,所以调用list1.add()时，编译器不知道要添加的具体类型，认为不安全。
         * 可以调用list1.get(),因为返回的类型肯定是Fruit的子类。
         * 协变
         */
        List<? extends Fruit> list1;
        list1 = new ArrayList<Orange>();
        //list1.add(new Apple);

        final String DEATH_STRING = "{\"a\":\"\\x";
        try {
            Object jsonObject = JSON.parse(DEATH_STRING);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        AbstractCollection


        String line = new String("[{\\x22a\\x22:\\x22a\\xB1ph.\\xCD\\x86\\xBEI\\xBA\\xC3\\xBCiM+\\xCE\\xCE\\x1E\\xDF7\\x1E\\xD9z\\xD9Q\\x8A}\\xD4\\xB2\\xD5\\xA0y\\x98\\x08@\\xE1!\\xA8\\xEF^\\x0D\\x7F\\xECX!\\xFF\\x06IP\\xEC\\x9F[\\x85;\\x02\\x817R\\x87\\xFB\\x1Ch\\xCB\\xC7\\xC6\\x06\\x8F\\xE2Z\\xDA^J\\xEB\\xBCF\\xA6\\xE6\\xF4\\xF7\\xC1\\xE3\\xA4T\\x89\\xC6\\xB2\\x5Cx]");
        line = line.replaceAll("\\\\x", "%");
        String decodeLog = null;
        try {
            decodeLog = URLDecoder.decode(line, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decodeLog);



        /**
         * list2指针可能指向List<Apple>,也可能指向List<Apple的任意父类>，所以调用list2.get()时，编译器不知道返回的具体类型（向上转型，没有向下转型），不可读取
         * 可以调用list2.add(Apple及其子类), Apple及其子类肯定是Apple的父类的子类。
         * 逆变
         */

        List<? super Apple> list2;
//        Apple apple = list2.get();

        DateInter dateInter = new DateInter();

    }

}
