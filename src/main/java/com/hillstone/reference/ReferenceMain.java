package com.hillstone.reference;

import java.lang.ref.*;
import java.sql.Struct;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: ljyang
 * @date: 2019/10/10 16:12
 * @description
 * 引用分为四类，
 * 强引用：Object a = new Object();
 * 软引用：在即将 OOM 之前，垃圾回收器会把这些软引用指向的对象加入回收范围
 * 弱引用：如果弱引用指向的对象只存在弱引用这一条线路，则在下一次 YGC 时会被回收。由于 YGC 时间的不确定性，弱引用何时被回收也具有不确定性。
 * 虚引用：是极弱的一种引用关系，定义完成后，就无法通过该引用获取指向的对象。
 *
 */

public class ReferenceMain {
    public static void main(String[] args) throws Exception{

        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

        SoftReference<String> stringSoftReference = new SoftReference<>("aaa");


        WeakReference<Integer> integerWeakReference = new WeakReference<>(1);

        String str = new String("qq");
        WeakReference<String> stringWeakReference = new WeakReference<>(str, referenceQueue);

//        PhantomReference<String> phantomReference = new PhantomReference<>(str);

        System.out.println(stringWeakReference.get());
        System.out.println(referenceQueue.poll());


        //避免str被强引用劫持，不能被垃圾回收，这样弱引用将毫无意义
        str = null;

        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        for(int i = 0; i<1000; i++){
            weakHashMap.put("a"+i, "b");
        }

        System.out.println(weakHashMap.size());
        System.gc();
        System.runFinalization();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(weakHashMap.size());
        System.out.println(referenceQueue.poll());



        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "aa");
        System.out.println(threadLocal.get());

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "1");
        linkedHashMap.put("b", "2");
        Iterator iterator = linkedHashMap.entrySet().iterator();
//        ThreadLocal
//        Thread
//        HashMap
    }
}

class T{
    public T() {
    }
    public final int a = 1;
}

class G extends T{

}

