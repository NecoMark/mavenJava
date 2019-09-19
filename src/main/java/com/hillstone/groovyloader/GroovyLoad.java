package com.hillstone.groovyloader;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: ljyang
 * @date: 2019/9/10 8:33
 * @description
 */

public class GroovyLoad {
    static GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
    public static void main(String[] args) {

        try {
            Class<?> demoClass = groovyClassLoader.parseClass(new File("./src\\main\\java\\com\\hillstone\\groovyloader/GroovyClass1.java"));
//            groovyClassLoader.loadClass("")
            Thread.currentThread().setContextClassLoader(groovyClassLoader);
            Method print = demoClass.getMethod("print");
            Object obj = demoClass.newInstance();
            print.invoke(obj);
            System.out.println("11111" + demoClass.getClassLoader());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        groovyClassLoader.clearCache();

    }
}
