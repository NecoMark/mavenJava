package com.hillstone.flinkcase;

import groovy.lang.GroovyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: ljyang
 * @date: 2019/9/10 14:15
 * @description
 */

public class FlinkCase {
    public static void main(String[] args) {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        try {
            Class<?> demoClass = groovyClassLoader.loadClass("com.hillstone.flinkcase.FlinkJob");
            Method execute = demoClass.getMethod("execute");
            Object obj = demoClass.newInstance();
            execute.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            groovyClassLoader.clearCache();
        }

    }
}
